/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface ICircuitoDAO {
    
    List<Circuito> buscarTodos();
   
    Circuito buscarPorId(Integer idCircuito);
    void guardarCircuito(Circuito circuito);
    void actualizarCircuito(Circuito circuito);
    void eliminarCircuito(Integer idCircuito);
    
}
