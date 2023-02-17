package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICochesJPA extends JpaRepository<Coche,Integer> {

    public List<Coche> findByNombreContainingIgnoreCase(String nombre);
   // public List<Coche> findByEquipo(Integer idequipo);
    public Coche findByCodigoContainingIgnoreCase(String codigo);

}
