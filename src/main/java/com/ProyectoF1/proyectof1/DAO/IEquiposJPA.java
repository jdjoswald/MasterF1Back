package com.ProyectoF1.proyectof1.DAO;
import com.ProyectoF1.proyectof1.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEquiposJPA extends JpaRepository<Equipo,Integer>{

   public List<Equipo> findByNombreContainingIgnoreCase(String nombre);

   public Equipo findByTeamChiefContainingIgnoreCase(String teamchief);

    public Equipo findByTechChiefContainingIgnoreCase (String techchief);

    public List<Equipo> findByBaseContainingIgnoreCase(String base);
}
