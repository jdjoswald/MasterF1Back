/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Usuario;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author joswald
 */
public interface UsuarioService {
    ArrayList<Usuario> getAllUser();
    Optional<Usuario> getUserById(Long id);
    boolean getUserByEmail(String email);
    boolean saveUser(Usuario u);
    boolean deleteUserById(Long id);
    
}
