package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IUsuariosImpl implements IUsuariosDAO{
    @Autowired
    IUsuariosJPA usuariosJPA;

    @Override
    public List<Usuario> buscarTodos() { return usuariosJPA.findAll();}

    @Override
    public Usuario buscarUsuarioPorid(Integer id) {
        Optional<Usuario> optional = usuariosJPA.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;}

    @Override
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        return usuariosJPA.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Usuario buscarUsuarioPorEmailAndPasswd(String email, String passwd) {
        return usuariosJPA.findByEmailAndAndContrasena( email,  passwd);
    }

    @Override
    public Usuario buscarUsuarioporNUsuario(String usuario) {
        return usuariosJPA.findByUsuario( usuario);
    }
    @Override
    public Usuario buscarUsuarioporEmail(String email) {
        return usuariosJPA.findByEmail(email);
    }

    /*@Override
    public List<Usuario> buscarUsuariosPorRol(Integer idRol) {
        return usuariosJPA.findById_Rol(idRol);
    }*/

    @Override
    public List<Usuario> buscarUsuariosPorFlagDef(boolean flag) {
        return usuariosJPA.findByDefinitivo(flag);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        System.out.println(usuario.getId());
        System.out.println(usuario.getUsuario());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getContrasena());
        System.out.println(usuario.getId_Rol().getId());
        System.out.println(usuario.getId_Rol().getRol());
        System.out.println(usuario.getDefinitivo());

        usuariosJPA.save(usuario);


    }

    @Override
    public void eliminarUsuario(Integer id) {usuariosJPA.deleteById(id);  }

    @Override
    public void actualizarUsuario(Usuario usuario) {usuariosJPA.save(usuario);   }
}
