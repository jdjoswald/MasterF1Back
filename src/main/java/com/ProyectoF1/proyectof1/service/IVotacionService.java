package com.ProyectoF1.proyectof1.service;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;

import java.time.LocalDate;
import java.util.List;

public interface IVotacionService {

    public List<Votacion> buscarTodas() ;


    public Votacion buscarVotacionPorid(Integer id);


    public List<Votacion> buscarVotacionPorTitulo(String titulo);


    public List<Votacion> buscarVotacionesPorFechaInicio(LocalDate fechaInicio);

    public List<Votacion> buscarVotacionesPorFechaCulminacion(LocalDate fechaCulminacion);

    boolean votar(Integer idVotacion, Voto voto);

    public boolean guardarVotacion(Votacion votacion);


    public boolean eliminarVotacion(Integer id);


    public boolean actualizarVotacion(Votacion votacion);

}
