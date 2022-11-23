package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuariosJPA extends JpaRepository<Usuario,Integer> {
    Usuario findByUsuario(String usuario);

    Usuario findByEmail(String email);

   /* List<Usuario> findById_Rol(Integer idRol);*/

    List<Usuario> findByDefinitivo(boolean flag);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    Usuario findByEmailAndAndContrasena(String email, String passwd);
}
