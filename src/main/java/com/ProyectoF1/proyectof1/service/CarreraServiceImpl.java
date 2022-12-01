/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.ICarreraDAO;
import com.ProyectoF1.proyectof1.DAO.ICircuitoDAO;
import com.ProyectoF1.proyectof1.model.Carrera;
import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class CarreraServiceImpl  implements ICarreraService{
    
      @Autowired
      ICarreraDAO carreraDAO;
      @Autowired
      ICircuitoDAO circuitoDAO;

    @Override
    public List<Carrera> buscarPorAnno(String anno) {
        return carreraDAO.buscarPorAnno(anno);
        
    }

    @Override
    public List<Carrera> buscarTodos() {
        return carreraDAO.buscarTodos();
    }

    @Override
    public Carrera buscarPorId(Integer idCarrera) {
        return carreraDAO.buscarPorId(idCarrera);
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        
        System.out.println(carrera.getCircuito().getNombre());
         carreraDAO.guardarCarrera(carrera);
         return carrera;
    }

    @Override
    public void actualizarCarrera(Carrera carrera) {
         carreraDAO.actualizarCarrera(carrera);
    }

    @Override
    public boolean eliminarCarrera(Integer idCarrera) {
         carreraDAO.eliminarCarrera(idCarrera);
                 return true;
    }
    
}
