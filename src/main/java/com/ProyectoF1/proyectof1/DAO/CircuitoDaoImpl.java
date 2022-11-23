/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public class CircuitoDaoImpl implements ICircuitoDAO{
    
     @Autowired
     ICircuitoJPA circuitoJPA;

    @Override
    public List<Circuito> buscarTodos() {
        return circuitoJPA.findAll();
    }

   

    @Override
    public Circuito buscarPorId(Integer idCircuito) {
       
        Optional<Circuito> optional =  circuitoJPA.findById(idCircuito);
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
    }

    @Override
    public void guardarCircuito(Circuito circuito) {
         circuitoJPA.save(circuito);
    }

    @Override
    public void actualizarCircuito(Circuito circuito) {
        circuitoJPA.save(circuito);
    }

    @Override
    public void eliminarCircuito(Integer idCircuito) {
        circuitoJPA.deleteById(idCircuito);
    }
    
}
