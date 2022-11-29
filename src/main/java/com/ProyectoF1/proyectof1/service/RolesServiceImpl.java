/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.IRolesDAO;
import com.ProyectoF1.proyectof1.model.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class RolesServiceImpl implements IRolesService{
    
    @Autowired
    IRolesDAO rolesDAO;

    @Override
    public List<Rol> buscarTodos() {
        return rolesDAO.buscarTodos();
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
            return rolesDAO.buscarPorId(idRol);
        
    }

    @Override
    public Rol guardarRol(Rol rol) {
          rolesDAO.guardarRol(rol);
            return rol;
        
    }

    @Override
    public void actualizarRol(Rol rol) {
            rolesDAO.guardarRol(rol);
            
        
    }

    @Override
    public boolean eliminarRol(Integer idRol) {
           
                    rolesDAO.eliminarRol(idRol);
                     return true;
        
    }
    
}
