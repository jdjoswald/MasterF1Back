package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Rol;
import com.ProyectoF1.proyectof1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface IRolesJPA extends JpaRepository<Rol, Integer> {

    /*Rol findById(Integer IdRol);*/

    Rol findByRol(String rol);

}
