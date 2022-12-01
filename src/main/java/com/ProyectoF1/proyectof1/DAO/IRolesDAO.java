package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Rol;

import java.util.List;

public interface IRolesDAO {
    
    
    
    List<Rol> buscarTodos();
    Rol buscarPorId(Integer idRol);
    void guardarRol(Rol rol);
    void actualizarRol(Rol rol);
    void eliminarRol(Integer idRol);

   /* public Rol buscarUsuarioPorid(Integer id);*/

    public Rol buscarRolPorNombre(String nombre);

}
