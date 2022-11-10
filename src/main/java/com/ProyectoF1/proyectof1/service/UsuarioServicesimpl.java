/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.IRolesDAO;
import com.ProyectoF1.proyectof1.DAO.IUsuariosDAO;
import com.ProyectoF1.proyectof1.model.Usuario;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicesimpl implements IUsuarioService{

    @Autowired
    IUsuariosDAO usuariosDAO;

    @Autowired
    IRolesDAO rolDAO;

    @Override
    public List<Usuario> buscarTodos() {return usuariosDAO.buscarTodos(); }

    @Override
    public Usuario buscarUsuarioPorid(Integer id) {
        return usuariosDAO.buscarUsuarioPorid(id);
    }

    @Override
    public List<Usuario> buscarUsuarioPorNombre(String nombre) {
        return usuariosDAO.buscarUsuarioPorNombre(nombre);
    }

    @Override
    public String buscarUsuarioPorEmailAndPasswd(String email, String passwd) {
        Usuario usuario = usuariosDAO.buscarUsuarioPorEmailAndPasswd(email, passwd);
        if (usuario != null) {
            return usuario.getUsuario();
        }
        return "";
    }

    @Override
    public Usuario buscarUsuarioporNUsuario(String usuario) {
        return usuariosDAO.buscarUsuarioporNUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuarioporEmail(String email) {
        return usuariosDAO.buscarUsuarioporEmail(email);
    }

   /* @Override
    public List<Usuario> buscarUsuariosPorRol(Integer idRol) {
        return usuariosDAO.buscarUsuariosPorRol(idRol);
    }*/

    @Override
    public List<Usuario> buscarUsuariosPorFlagDef(boolean flag) {
        return usuariosDAO.buscarUsuariosPorFlagDef(flag);
    }

    @Override
    public boolean guardarUsuario(Usuario usuario) {
       if ((usuariosDAO.buscarUsuarioporEmail(usuario.getEmail())== null)&&
          (usuariosDAO.buscarUsuarioporNUsuario(usuario.getUsuario())==null))
       {
           usuariosDAO.guardarUsuario(usuario);
           return true;
       }
        return false;
    }

    @Override
    public boolean eliminarUsuario(String email) {
        Usuario usuario = usuariosDAO.buscarUsuarioporEmail(email);
        if( usuario !=null){
            usuariosDAO.eliminarUsuario(usuario.getId());
            return true;
        }

        return false;

    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        if (usuariosDAO.buscarUsuarioporEmail(usuario.getEmail())!= null){
        usuariosDAO.guardarUsuario(usuario);
        return true;
    }

        return false;

    }
}
