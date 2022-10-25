/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoF1.proyectof1.model.Usuario;

/**
 *
 * @author joswald
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
