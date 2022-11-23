/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Circuito;
import com.ProyectoF1.proyectof1.service.ICircuitoService;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joswald
 */
@RestController
@RequestMapping("circuito")
public class circuitoController {
    
     @Autowired
     ICircuitoService circuitoService;
     
    @GetMapping("/all")
    public List<Circuito> buscarTodos() {
        return circuitoService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Circuito circuitoPorId(@PathVariable("id") Integer id) {
        return circuitoService.buscarPorId(id);
    }
    
    @PostMapping("/save")
    public Circuito guardarcCircuito(@RequestBody Circuito circuito){
       
        return circuitoService.guardarCircuito(circuito);
    }
    @PutMapping("/update")
    public Circuito editCircuito(@RequestBody Circuito circuito){
       
        return circuitoService.guardarCircuito(circuito);
    }
    
}
