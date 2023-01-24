package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;

import java.util.List;

public interface ICocheService {

    public List<Coche> buscarTodos() ;


    public Coche buscarCochePorid(Integer id);

    public Coche buscarCochePorCodigo(String siglas);

    public List<Coche> buscarCochePorNombre(String nombre);


    public boolean guardarCoche(Coche coche);


    public boolean eliminarCoche(Integer id);


    public boolean actualizarCoche(Coche coche);

    public boolean addEquipo(Integer idCoche, Integer idEquipo);


    public boolean deleteEquipo(Integer idCoche);
}
