/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.ICircuitoDAO;
import com.ProyectoF1.proyectof1.model.Circuito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class CircuitoServiceImpl implements ICircuitoService{
    
    @Autowired
    ICircuitoDAO  circuitoDao;

    @Override
    public List<Circuito> buscarTodos() {
       return circuitoDao.buscarTodos();
    }

    @Override
    public Circuito buscarPorId(Integer idCircuito) {
       return circuitoDao.buscarPorId(idCircuito);
    }

    @Override
    public Circuito guardarCircuito(Circuito circuito) {
        circuitoDao.guardarCircuito(circuito);
        return circuito;
    }

    @Override
    public void actualizarCircuito(Circuito circuito) {
        circuitoDao.actualizarCircuito(circuito);
    }

    @Override
    public boolean eliminarCircuito(Integer idCircuito) {
        circuitoDao.eliminarCircuito(idCircuito);
        return true;
    }
    
}
