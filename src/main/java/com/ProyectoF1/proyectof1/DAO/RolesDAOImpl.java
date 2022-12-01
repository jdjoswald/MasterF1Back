package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Rol;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RolesDAOImpl implements IRolesDAO{
    @Autowired
    IRolesJPA rolesJPA;

   /* @Override
    public Rol buscarUsuarioPorid(Integer id) {
        return rolesJPA.findByIdRol(id);}*/


    @Override
    public Rol buscarRolPorNombre(String nombre) {
        return rolesJPA.findByRol(nombre);
    }

    @Override
    public List<Rol> buscarTodos() {
        return rolesJPA.findAll();
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
        Optional<Rol> optional = rolesJPA.findById(idRol); 
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;  }

    @Override
    public void guardarRol(Rol rol) {
        rolesJPA.save(rol);
    }

    @Override
    public void actualizarRol(Rol rol) {
         rolesJPA.save(rol);
    }

    @Override
    public void eliminarRol(Integer idRol) {
      rolesJPA.deleteById(idRol);   
    }
}
