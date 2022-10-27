/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.service.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ProyectoF1.proyectof1.model.Usuario;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author joswald
 */
@RestController
@RequestMapping("user")
public class usuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/all")
    public ArrayList<Usuario> getAllUser(){
        return usuarioService.getAllUser();
    }
    @PostMapping("/find/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id")long id){
    return usuarioService.getUserById(id);
    }
     @PostMapping("/findmail/{id}")
    public boolean getUserByEmail(@PathVariable("id")String id){
    return usuarioService.getUserByEmail(id);
    }
    @PostMapping("/save")
    public String saveUser(@RequestBody Usuario u){
         //return u;
         if (usuarioService.saveUser(u)== true){
             return "usuario creado";
         }else{
             return "usuario existente";
         }
          
    }
    @PostMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id){
        if(usuarioService.deleteUserById(id)){
            return("Usuario no eliminado");
        }
        else{
            return("Usuario no eliminado") ;
        }
     
    }
    
}
