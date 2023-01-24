/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface ICircuitoService {
    
    List<Circuito> buscarTodos();
    List<Circuito> buscarPorNombre(String nombre);
    Circuito buscarPorId(Integer idCircuito);
    Circuito guardarCircuito(Circuito circuito);
    void actualizarCircuito(Circuito circuito);
    boolean eliminarCircuito(Integer idCircuito);
    
}
