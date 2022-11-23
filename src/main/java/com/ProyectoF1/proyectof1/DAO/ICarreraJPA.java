/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joswald
 */
public interface ICarreraJPA extends JpaRepository<Carrera, Integer>{
    List<Carrera> findByFechaContainingIgnoreCase(String fecha);

    
}
