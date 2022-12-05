package com.ProyectoF1.proyectof1.controllers;


import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.service.IPilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pilotos")
public class pilotosController {

    @Autowired
    IPilotoService pilotosService;

    @GetMapping("/all")
    public List<Piloto> buscarTodos(){
        return pilotosService.buscarTodos();
    }
}
