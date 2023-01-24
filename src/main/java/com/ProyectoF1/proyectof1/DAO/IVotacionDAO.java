package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface IVotacionDAO extends Serializable {

    public List<Votacion> buscarTodas() ;


    public Votacion buscarVotacionPorid(Integer id);


    public List<Votacion> buscarVotacionPorTitulo(String titulo);


    public List<Votacion> buscarVotacionsPorFechaInicio(LocalDate fechaInico);

    public List<Votacion> buscarVotacionsPorFechaCulminacion(LocalDate fechaCulminacion);


    public void guardarVotacion(Votacion votacion);


    public void eliminarVotacion(Integer id);


    public void actualizarVotacion(Votacion votacion);

    void addVoto(Votacion votacion, Voto voto);

    List<Voto> deleteVotos(Votacion votacion);
}
