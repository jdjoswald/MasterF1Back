package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;

import java.io.Serializable;
import java.util.List;

public interface IPilotosDAO extends Serializable {

    public List<Piloto> buscarTodos() ;


    public Piloto buscarPilotoPorid(Integer id);

    public Piloto buscarPilotoPorSiglas(String siglas);

    public Piloto buscarPilotoPorNombreApellidos(String nombre, String apellidos);

    public List<Piloto> buscarPilotoPorNombre(String nombre);

    public List<Piloto> buscarPilotoPorApellidos( String apellidos);

    public List<Piloto> buscarPilotoPorPais(String pais);


    public void guardarPiloto(Piloto piloto);


    public void eliminarPiloto(Integer id);


    public void actualizarPiloto(Piloto piloto);

    public void addEquipo(Integer idPiloto, Equipo equipo);


    public void deleteEquipo(Integer idPiloto);

}
