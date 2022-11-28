/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Carrera;
import com.ProyectoF1.proyectof1.model.Noticia;
import com.ProyectoF1.proyectof1.service.CarreraServiceImpl;
import com.ProyectoF1.proyectof1.service.ICarreraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("carrera")
public class carreraController {
     @Autowired
     ICarreraService carreraService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/calendario/{anno}")
    public List<Carrera> calendario(@PathVariable("anno") String anno) {
        
        return carreraService.buscarPorAnno(anno);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Carrera> buscarTodos() {
        return carreraService.buscarTodos();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Carrera carreraPorId(@PathVariable("id") Integer id) {
        return carreraService.buscarPorId(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Carrera guardarCarrera(@RequestBody Carrera carrera){
       
        return carreraService.guardarCarrera(carrera);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update")
    public Carrera editCarrera(@RequestBody Carrera carrera){
       
        return carreraService.guardarCarrera(carrera);
    }
    
    
}
