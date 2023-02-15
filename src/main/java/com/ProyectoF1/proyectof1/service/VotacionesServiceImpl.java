package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.IPilotosDAO;
import com.ProyectoF1.proyectof1.DAO.IVotacionDAO;
import com.ProyectoF1.proyectof1.DAO.IVotosDAO;
import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.model.Recuento;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class VotacionesServiceImpl implements IVotacionService{

    @Autowired
    IVotacionDAO votacionDAO;

    @Autowired
    IVotosDAO votosDAO;

    @Autowired
    IPilotosDAO pilotosDAO;

    @Override
    public List<Votacion> buscarTodas() {
        
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
        System.out.println("PASA POR VOTACIONES SERVICE");
        
         if( votacion.getPilotos()!=null){
            List<Piloto> pilotos= new ArrayList<>();
            votacion.getPilotos().forEach((e) -> { 
                System.out.println(e.getId()); 
                pilotos.add(pilotosDAO.buscarPilotoPorid(e.getId()));
            });
            votacion.setPilotos(pilotos);
        }
         
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

    @Override
    public HashMap<String, Integer> resultadosVotacion(Integer idVotacion) {
        HashMap<String,Integer> resultados = new HashMap<>();
        Votacion votacion = votacionDAO.buscarVotacionPorid(idVotacion);
        String piloto = "";
        if (votacion != null){
            List<Voto> votos= votacion.getVotos();
            for(Voto voto:votos){
                piloto = pilotosDAO.buscarPilotoPorid(voto.getIdPiloto()).getNombre()+" "+pilotosDAO.buscarPilotoPorid(voto.getIdPiloto()).getApellidos() +"("+pilotosDAO.buscarPilotoPorid(voto.getIdPiloto()).getEquipo().getNombre()+")";
                    if ((!resultados.containsKey(piloto))){
                        resultados.put(piloto,1);
                    }else{
                        resultados.replace(piloto, resultados.get(piloto)+1);
                    }
                }
            }
        return resultados;
    }

    @Override
    public List<Recuento> recuento(Integer idVotacion) {
        
        List<Recuento> lista= new ArrayList();
        
          HashMap<Integer,Integer> resultados = new HashMap<>();
        Votacion votacion = votacionDAO.buscarVotacionPorid(idVotacion);
        Integer piloto = 0;
        if (votacion != null){
            List<Voto> votos= votacion.getVotos();
            for(Voto voto:votos){
                piloto = pilotosDAO.buscarPilotoPorid(voto.getIdPiloto()).getId();
                    if ((!resultados.containsKey(piloto))){
                        resultados.put(piloto,1);
                    }else{
                        resultados.replace(piloto, resultados.get(piloto)+1);
                    }
                }
            }
        Integer c=1;
        
        for (Map.Entry<Integer, Integer> entry : resultados.entrySet()) {
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    //System.out.println(new Recuento(pilotosDAO.buscarPilotoPorid(entry.getKey()), entry.getValue()));

                    lista.add(new Recuento(c,pilotosDAO.buscarPilotoPorid(entry.getKey()), entry.getValue()));
                    c=c+1;
            }
        
        
         
         
        
        
        
        return lista;
       
    }


}
