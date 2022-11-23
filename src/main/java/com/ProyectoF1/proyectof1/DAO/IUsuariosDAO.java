package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Usuario;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IUsuariosDAO extends Serializable {

    
    public List<Usuario> buscarTodos() ;

    
    public Usuario buscarUsuarioPorid(Integer id);

    
    public List<Usuario> buscarUsuarioPorNombre(String nombre);

    
    public Usuario buscarUsuarioPorEmailAndPasswd(String email, String passwd);

    
    public Usuario buscarUsuarioporNUsuario(String usuario);
    
    public Usuario buscarUsuarioporEmail(String email);

    
   /* public List<Usuario> buscarUsuariosPorRol(Integer idRol);*/

    
    public List<Usuario> buscarUsuariosPorFlagDef(boolean flag);

    
    public void guardarUsuario(Usuario usuario);

    
    public void eliminarUsuario(Integer id);

    
    public void actualizarUsuario(Usuario usuario);
}
