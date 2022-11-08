/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Noticia;
import com.ProyectoF1.proyectof1.service.NoticiaService;
import com.ProyectoF1.proyectof1.service.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;
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
    NoticiaService noticiaService;
    
    @GetMapping("/all")
    public ArrayList<Noticia> getAllUser(){
        return noticiaService.getAllNoticia();
    }
    
    @GetMapping("/find/{id}")
    public Optional<Noticia> getUserById(@PathVariable("id")Integer id){
    return noticiaService.getNoticiaById(id);
    }
     
    @PostMapping("/save")
    public Noticia saveUser(@RequestBody Noticia u){
        noticiaService.saveNoticia(u);
         return u;
        
          
    }
    @PostMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        if(noticiaService.deleteNoticiaById(id)){
            return("Usuario no eliminado");
        }
        else{
            return("Usuario no eliminado") ;
        }
     
    }
    
}