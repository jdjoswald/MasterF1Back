package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.IVotacionDAO;
import com.ProyectoF1.proyectof1.DAO.IVotosDAO;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VotacionesServiceImpl implements IVotacionService{

    @Autowired
    IVotacionDAO votacionDAO;

    @Autowired
    IVotosDAO votosDAO;

    @Override
    public List<Votacion> buscarTodas() {
        System.out.println("PASA POR VOTACIONES SERVICE");
        return votacionDAO.buscarTodas();
    }

    @Override
    public Votacion buscarVotacionPorid(Integer id) {
        return votacionDAO.buscarVotacionPorid(id);
    }

    @Override
    public List<Votacion> buscarVotacionPorTitulo(String titulo) {
        return votacionDAO.buscarVotacionPorTitulo(titulo);
    }

    @Override
    public List<Votacion> buscarVotacionesPorFechaInicio(LocalDate fechaInicio) {
        return votacionDAO.buscarVotacionsPorFechaInicio(fechaInicio);
    }

    @Override
    public List<Votacion> buscarVotacionesPorFechaCulminacion(LocalDate fechaCulminacion) {
        return votacionDAO.buscarVotacionsPorFechaCulminacion(fechaCulminacion);
    }

    @Override
    public boolean votar(Integer idVotacion, Voto voto) {
            Votacion encuesta = votacionDAO.buscarVotacionPorid(idVotacion);
            Voto votoAux = votosDAO.buscarVotoPorVotacionYCorreo(encuesta, voto.getEmail());
           if (encuesta!=null &&
                   encuesta.isPilotoInVotacion(voto.getIdPiloto()) && votoAux==null){
               voto.setIdVotacion(encuesta);
               votosDAO.guardarVoto(voto);
               votacionDAO.addVoto(encuesta, votosDAO.buscarVotoPorVotacionYCorreo(encuesta, voto.getEmail()));
               return true;
           }
        return false;
    }

    @Override
    public boolean guardarVotacion(Votacion votacion) {
        votacionDAO.guardarVotacion(votacion);
        return true;
    }

    @Override
    public boolean eliminarVotacion(Integer id) {
        Votacion votacion = votacionDAO.buscarVotacionPorid(id);
        if (votacion != null){
            List<Voto> votos= votacionDAO.deleteVotos(votacion);
            votosDAO.eliminarVotos(votos);
            votacionDAO.eliminarVotacion(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarVotacion(Votacion votacion) {
        votacionDAO.actualizarVotacion(votacion);
        return true;
    }
}
