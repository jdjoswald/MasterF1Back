/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class UsuarioServicesimpl implements UsuarioService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ArrayList<Usuario> getAllUser() {
         return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUserById(Long id) {
      return usuarioRepository.findById(id);  }

    @Override
    public boolean saveUser(Usuario u) {
        if(getUserByEmail(u.getEmail())== true){
        return false;
        }
      usuarioRepository.save(u);  
     return true;
    }

    @Override
    public boolean deleteUserById(Long id) {
      try {
            Optional<Usuario> u = getUserById(id);
            usuarioRepository.delete(u.get());
            return true;
            
        } catch (Exception e) {
        return false;
        }     }

    @Override
    public boolean getUserByEmail(String email) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //    boolean resultado= false;
        //Usuario user=null;
       ArrayList<Usuario> result = getAllUser();
       
        for (Usuario p:result) {
            // formato clasico
         if(p.getEmail().equals(email)){
         return true;}
      }
         return false;
    }
   
        
     
    
    
    
    
}
