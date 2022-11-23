/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Carrera;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Repository
public class CarreraDaoImpl implements ICarreraDAO{
    
     @Autowired
     ICarreraJPA carreraJPA;

    @Override
    public List<Carrera> buscarTodos() {
        return carreraJPA.findAll();
        
    }

    @Override
    public Carrera buscarPorId(Integer idCarrera) {
       
         Optional<Carrera> optional =  carreraJPA.findById(idCarrera);
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
    }

    @Override
    public void guardarCarrera(Carrera carrera) {
       carreraJPA.save(carrera);
    }

    @Override
    public void actualizarCarrera(Carrera carrera) {
       carreraJPA.save(carrera);
    }

    @Override
    public void eliminarCarrera(Integer idCarrera) {
        carreraJPA.deleteById(idCarrera);
    }

    @Override
    public List<Carrera> buscarPorAnno(String anno) {
        return carreraJPA.findByFechaContainingIgnoreCase(anno);
    }
    
}
