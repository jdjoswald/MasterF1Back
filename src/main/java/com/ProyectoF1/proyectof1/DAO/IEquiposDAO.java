package com.ProyectoF1.proyectof1.DAO;
import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;

import java.util.*;

public interface IEquiposDAO {

    public List<Equipo> buscarTodos();

    public Equipo buscarEquipoPorid(Integer id);

    public List<Equipo> buscarEquipoPorBase (String base);

    public Equipo buscarEquipoPorNombre (String nombre);

    public void guardarEquipo(Equipo equipo);

    public void eliminarEquipo (Integer id);

    public void actualizarEquipo (Equipo equipo);

    public void addPiloto(Integer idEquipo, Piloto piloto);

    public void deletePiloto(Integer idEquipo, Integer idPiloto);

    public void addCoche( Integer idEquipo, Coche coche);

    public void deleteCoche(Integer idEquipo, Integer idCoche) ;



}
