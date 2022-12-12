package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.ICochesDAO;
import com.ProyectoF1.proyectof1.DAO.IEquiposDAO;
import com.ProyectoF1.proyectof1.DAO.IPilotosDAO;
import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Service
public class EquipoServiceImpl implements IEquipoService{
    private final static String URL_IMAGEN = "/EquiposImg/";
    @Autowired
    IEquiposDAO equiposDAO;

    @Autowired
    IPilotosDAO pilotosDAO;

    @Autowired
    ICochesDAO cochesDAO;

    @Override
    public List<Equipo> buscarTodos() { return equiposDAO.buscarTodos(); }

    @Override
    public Equipo buscarEquipoPorId(Integer id) { return equiposDAO.buscarEquipoPorid(id);}

    @Override
    public List<Equipo> buscarEquipoPorBase(String base) {return equiposDAO.buscarEquipoPorBase(base);}

    @Override
    public Equipo buscarEquipoPorNombre(String nombre) {return equiposDAO.buscarEquipoPorNombre(nombre); }

    @Override
    public boolean guardarEquipo(Equipo equipo) {
        if (equiposDAO.buscarEquipoPorNombre(equipo.getNombre()) == null) {
            equiposDAO.guardarEquipo(equipo);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarEquipo(Integer id) {
        Equipo equipo = equiposDAO.buscarEquipoPorid(id);
        if (equipo != null){
            List<Piloto> pilotos = equipo.getPilotos();
            for (Piloto piloto: pilotos){
                pilotosDAO.deleteEquipo(piloto.getId());
            }
            equiposDAO.eliminarEquipo(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarEquipo(Equipo equipo){
        if (equiposDAO.buscarEquipoPorid(equipo.getId()) != null) { 
            
            equiposDAO.guardarEquipo(equipo);
            return true;
        }
        System.out.println("com.ProyectoF1.proyectof1.service.EquipoServiceImpl.actualizarEquipo()");
        return false;
    }

    @Override
    public boolean addPiloto(Integer idEquipo, Integer idpiloto) {

        Piloto piloto = pilotosDAO.buscarPilotoPorid(idpiloto);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((piloto!=null)&&(equipo!=null))
        {
            equiposDAO.addPiloto(idEquipo, piloto);
            pilotosDAO.addEquipo(idpiloto,equipo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePiloto(Integer idEquipo, Integer idPiloto) {

        Piloto piloto = pilotosDAO.buscarPilotoPorid(idPiloto);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((piloto!=null)&&(equipo!=null)&&equipo.isPilotoinEquipo(idPiloto))
        {
            equiposDAO.deletePiloto(idEquipo, idPiloto);
            pilotosDAO.deleteEquipo(idPiloto);
            return true;

        }
        return false;
    }

    @Override
    public boolean addCoche(Integer idEquipo, Integer idCoche) {
        Coche coche = cochesDAO.buscarCochePorid(idCoche);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((coche!=null)&&(equipo!=null))
        {
            equiposDAO.addCoche(idEquipo, coche);
            cochesDAO.addEquipo(idCoche,equipo);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCoche(Integer idEquipo, Integer idCoche) {

        Coche coche = cochesDAO.buscarCochePorid(idCoche);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((coche!=null)&&(equipo!=null)&&equipo.isCocheinEquipo(idCoche))
        {
            equiposDAO.deletePiloto(idEquipo, idCoche);
            pilotosDAO.deleteEquipo(idCoche);
            return true;

        }
        return false;

    }

    @Override
    public byte[] buscarEquipoimg(Integer idEquipo) throws IOException {
        String imagen = equiposDAO.buscarEquipoPorid(idEquipo).getLogo();
        InputStream in = getClass().getResourceAsStream(URL_IMAGEN+"not_found.jpg");
        if((imagen != "") && (imagen != null)){
            in = getClass().getResourceAsStream(imagen);
        }
        return IOUtils.toByteArray(in);
    }
}
