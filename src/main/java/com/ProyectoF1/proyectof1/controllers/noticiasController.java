/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Noticia;
import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.service.INoticiaService;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("news")
public class noticiasController {
    @Autowired
    INoticiaService noticiaService;
    @Autowired
    IUsuarioService usuarioService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Noticia> buscarTodos() {
        return noticiaService.buscarTodos();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/{id}")
    public Noticia noticiaPorId(@PathVariable("id") Integer id) {
        return noticiaService.buscarPorId(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public Noticia guardarNoticia(@RequestBody Noticia noticia){
        var user=noticia.getIdUsuario();
        noticia.setIdUsuario(usuarioService.buscarUsuarioPorid(user.getId()));
        return noticiaService.guardarNoticia(noticia);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update")
    public Noticia editNoticia(@RequestBody Noticia noticia){
       
              Usuario user=  noticiaService.buscarPorId(noticia.getId()).getIdUsuario();
        
       
         noticia.setIdUsuario(user);
         noticiaService.actualizarNoticia(noticia);
         return noticia;
    }
    
     @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping ("/delete/{id}")
    public boolean deleteUserById(@PathVariable("id") Integer id){
        
       return noticiaService.eliminarNoticia(id);
    }
    
    
}