package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolesDAOImpl implements IRolesDAO{
    @Autowired
    IRolesJPA rolesJPA;

    @Override
    public Rol buscarUsuarioPorid(Integer id) {
        return rolesJPA.findByIdRol(id);
    }

    @Override
    public Rol buscarRolPorNombre(String nombre) {
        return rolesJPA.findByRol(nombre);
    }
}
