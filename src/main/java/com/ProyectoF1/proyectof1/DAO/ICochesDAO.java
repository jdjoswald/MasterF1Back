package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;

import java.util.List;

public interface ICochesDAO {

    public List<Coche> buscarTodos() ;


    public Coche buscarCochePorid(Integer id);

    public Coche buscarCochePorCodigo(String siglas);

    public Coche buscarCochePorNombre(String nombre);


    public void guardarCoche(Coche coche);


    public void eliminarCoche(Integer id);


    public void actualizarCoche(Coche coche);

    public void addEquipo(Integer idCoche, Equipo equipo);


    public void deleteEquipo(Integer idCoche);
}
