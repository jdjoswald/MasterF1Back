/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.IEquiposDAO;
import com.ProyectoF1.proyectof1.DAO.IRolesDAO;
import com.ProyectoF1.proyectof1.DAO.IUsuariosDAO;
import com.ProyectoF1.proyectof1.model.Equipo;
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
     @Autowired
     IEquiposDAO equipoDAO;

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
       if ((usuario.getContrasena().length()>= 8) &&
          (usuariosDAO.buscarUsuarioporEmail(usuario.getEmail())== null)&&
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
        if (usuariosDAO.buscarUsuarioPorid(usuario.getId())!= null){
            Equipo equipo= equipoDAO.buscarEquipoPorid(usuario.getId());
                    usuario.setIdEquipo(equipo);
        usuariosDAO.guardarUsuario(usuario);
        return true;
    }

        return false;

    }

    @Override
    public boolean aprobarUsuario(Usuario usuario) {
        Usuario user = usuariosDAO.buscarUsuarioporEmail(usuario.getEmail());
        if (user!=null){
            user.setDefinitivo(true);
            usuariosDAO.actualizarUsuario(user);
            return true;
        }

        return false;

    }
}
