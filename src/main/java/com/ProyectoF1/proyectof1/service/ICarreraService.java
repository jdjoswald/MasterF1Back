/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Carrera;
import java.util.List;
import java.util.Set;

/**
 *
 * @author joswald
 */
public interface ICarreraService {
    List<Carrera> buscarPorAnno(String anno);
    
     List<Carrera> buscarTodos();
    Carrera buscarPorId(Integer idCarrera);
    Carrera guardarCarrera(Carrera carrera);
    void actualizarCarrera(Carrera carrera);
    boolean eliminarCarrera(Integer idCarrera);
}
