/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joswald
 */
public interface ICircuitoJPA extends JpaRepository<Circuito, Integer>{
     List<Circuito> findByNombreContainingIgnoreCase(String nombre);
}
