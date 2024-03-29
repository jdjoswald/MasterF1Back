package com.ProyectoF1.proyectof1.service;
import com.ProyectoF1.proyectof1.DAO.IEquiposDAO;
import com.ProyectoF1.proyectof1.DAO.IPilotosDAO;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

@Service
public class PilotoServiceImpl implements IPilotoService {

    private final static String URL_IMAGEN = "/PilotosImg/";
    @Autowired
    IPilotosDAO pilotosDAO;

    @Autowired
    IEquiposDAO equiposDAO;


    @Override
    public List<Piloto> buscarTodos() { return pilotosDAO.buscarTodos(); }

    @Override
    public Piloto buscarPilotoPorid(Integer id) { return pilotosDAO.buscarPilotoPorid(id); }

    @Override
    public Piloto buscarPilotoPorSiglas(String siglas) { return pilotosDAO.buscarPilotoPorSiglas(siglas);}

    @Override
    public Piloto buscarPilotoPorNombreApellidos(String nombre, String apellidos) {
        return pilotosDAO.buscarPilotoPorNombreApellidos(nombre, apellidos);
    }

    @Override
    public List<Piloto> buscarPilotoPorNombre(String nombre) {
        return pilotosDAO.buscarPilotoPorNombre(nombre);
    }

    @Override
    public List<Piloto> buscarPilotoPorApellidos(String apellidos) {
        return pilotosDAO.buscarPilotoPorApellidos(apellidos);
    }

    @Override
    public List<Piloto> buscarPilotoPorPais(String pais) {
        return pilotosDAO.buscarPilotoPorPais(pais);
    }


    @Override
    public boolean guardarPiloto(Piloto piloto) {
        if ((pilotosDAO.buscarPilotoPorNombreApellidos(piloto.getNombre(), piloto.getApellidos()) == null)&& piloto.getId() ==null) {
            pilotosDAO.guardarPiloto(piloto);
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarPiloto(Integer id) {
        Piloto piloto = pilotosDAO.buscarPilotoPorid(id);
        if (piloto != null){
            Equipo equipo = piloto.getEquipo();
            equiposDAO.deletePiloto(equipo.getId(),id);
            pilotosDAO.eliminarPiloto(piloto.getId());
            return true;
            }
        return false;
    }

    @Override
    public boolean actualizarPiloto(Piloto piloto) {
        if (pilotosDAO.buscarPilotoPorNombreApellidos(piloto.getNombre(),piloto.getApellidos()) != null) {
            pilotosDAO.actualizarPiloto(piloto);
            return true;
        }
        return false;

    }

    @Override
    public boolean addEquipo(Integer idPiloto, Integer idEquipo) {
        Piloto piloto = pilotosDAO.buscarPilotoPorid(idPiloto);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((piloto!=null)&&(equipo!=null))
        {
            equiposDAO.addPiloto(idEquipo, piloto);
            pilotosDAO.addEquipo(idPiloto,equipo);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteEquipo(Integer idPiloto, Integer idEquipo) {
        Piloto piloto = pilotosDAO.buscarPilotoPorid(idPiloto);
        Equipo equipo = equiposDAO.buscarEquipoPorid(idEquipo);
        if ((piloto!=null)&&(equipo!=null)&& equipo.isPilotoinEquipo(idPiloto))
        {
            equiposDAO.deletePiloto(idEquipo, idPiloto);
            pilotosDAO.deleteEquipo(idPiloto);
            return true;

        }
        return false;

    }

    @Override
    public byte[] buscarPilotoimg(Integer idPiloto) throws IOException {
        String imagen = pilotosDAO.buscarPilotoPorid(idPiloto).getFoto();
        InputStream in = getClass().getResourceAsStream(URL_IMAGEN+"not_found.jpg");
        if((imagen != "") && (imagen != null)){
            in = getClass().getResourceAsStream(imagen);
        }
        return IOUtils.toByteArray(in);
    }

}
