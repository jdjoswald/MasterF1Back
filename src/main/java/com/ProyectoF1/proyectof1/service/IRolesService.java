/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Rol;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface IRolesService {
    List<Rol> buscarTodos();
    Rol buscarPorId(Integer idRol);
    Rol guardarRol(Rol rol);
    void actualizarRol(Rol rol);
    boolean eliminarRol(Integer idRol);
}
