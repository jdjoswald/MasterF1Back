package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Rol;

import java.util.List;

public interface IRolesDAO {

    public Rol buscarUsuarioPorid(Integer id);

    public Rol buscarRolPorNombre(String nombre);

}
