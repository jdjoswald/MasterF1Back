package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;

import java.util.List;

public interface IEquipoService {

    public List<Equipo> buscarTodos();

    public Equipo buscarEquipoPorId(Integer id);

    public List<Equipo> buscarEquipoPorBase (String base);

    public Equipo buscarEquipoPorNombre (String nombre);

    public boolean guardarEquipo(Equipo equipo);

    public boolean eliminarEquipo (Integer id);

    public boolean actualizarEquipo (Equipo equipo);

    public boolean addPiloto(Integer idEquipo, Integer idpiloto);

    public boolean deletePiloto(Integer idEquipo, Integer idPiloto);

    public boolean addCoche(Integer idEquipo, Integer idCoche) ;

    public boolean deleteCoche(Integer idEquipo, Integer idCoche) ;

}
