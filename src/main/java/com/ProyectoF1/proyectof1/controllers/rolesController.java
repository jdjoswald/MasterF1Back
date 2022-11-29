/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Rol;
import com.ProyectoF1.proyectof1.service.IRolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joswald
 */

@RestController
@RequestMapping("roles")
@CrossOrigin
public class rolesController {
    
    @Autowired
     IRolesService rolesService;
    
    @GetMapping("/all")
    public List<Rol> buscarTodos() {
        return rolesService.buscarTodos();
    }
    
}
