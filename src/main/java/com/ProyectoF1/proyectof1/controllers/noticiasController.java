/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Noticia;
import com.ProyectoF1.proyectof1.service.INoticiaService;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joswald
 */
@RestController
@RequestMapping("news")
public class noticiasController {
    @Autowired
    INoticiaService noticiaService;
    @Autowired
    IUsuarioService usuarioService;
    
    @GetMapping("/all")
    public List<Noticia> buscarTodos() {
        return noticiaService.buscarTodos();
    }
    @GetMapping("/user/{id}")
    public Noticia noticiaPorId(@PathVariable("id") Integer id) {
        return noticiaService.buscarPorId(id);
    }
    
    @PostMapping("/save")
    public Noticia guardarUsuario(@RequestBody Noticia noticia){
        var user=noticia.getIdUsuario();
        noticia.setIdUsuario(usuarioService.buscarUsuarioPorid(user.getId()));
        return noticiaService.guardarNoticia(noticia);
    }
    
}