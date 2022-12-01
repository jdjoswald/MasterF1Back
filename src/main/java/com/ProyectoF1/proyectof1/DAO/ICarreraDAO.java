/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Carrera;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface ICarreraDAO {
    List<Carrera> buscarTodos();
    List<Carrera> buscarPorAnno(String anno);
    Carrera buscarPorId(Integer idCarrera);
    void guardarCarrera(Carrera carrera);
    void actualizarCarrera(Carrera carrera);
    void eliminarCarrera(Integer idCarrera);
    
}
