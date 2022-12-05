package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICochesJPA extends JpaRepository<Coche,Integer> {

    public Coche findByNombreContainingIgnoreCase(String nombre);

    public Coche findByCodigoContainingIgnoreCase(String codigo);

}
