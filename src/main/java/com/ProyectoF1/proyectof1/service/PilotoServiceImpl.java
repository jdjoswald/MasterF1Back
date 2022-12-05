package com.ProyectoF1.proyectof1.service;
import com.ProyectoF1.proyectof1.DAO.IEquiposDAO;
import com.ProyectoF1.proyectof1.DAO.IPilotosDAO;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PilotoServiceImpl implements IPilotoService {
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
    public boolean guardarPiloto(Piloto piloto) {
        if (pilotosDAO.buscarPilotoPorNombreApellidos(piloto.getNombre(), piloto.getApellidos()) == null) {
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
            pilotosDAO.deleteEquipo(piloto.getId());
            return true;
            }
        return false;
    }

    @Override
    public boolean actualizarPiloto(Piloto piloto) {
        if (pilotosDAO.buscarPilotoPorNombreApellidos(piloto.getNombre(),piloto.getApellidos()) != null) {
            pilotosDAO.guardarPiloto(piloto);
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
}
