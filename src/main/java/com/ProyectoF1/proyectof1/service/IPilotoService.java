package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;

import java.util.List;

public interface IPilotoService {

    public List<Piloto> buscarTodos() ;

    public Piloto buscarPilotoPorid(Integer id);

    public Piloto buscarPilotoPorSiglas(String siglas);

    public Piloto buscarPilotoPorNombreApellidos(String nombre, String apellidos);

    public boolean guardarPiloto(Piloto piloto);

    public boolean eliminarPiloto(Integer id);

    public boolean actualizarPiloto(Piloto piloto);

    public boolean addEquipo(Integer idPiloto, Integer idEquipo);

    public boolean deleteEquipo(Integer idPiloto, Integer idEquipo);
}