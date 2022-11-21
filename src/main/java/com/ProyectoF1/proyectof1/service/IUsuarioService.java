/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public List<Usuario> buscarTodos();
    public Usuario buscarUsuarioPorid(Integer id);
    public List<Usuario> buscarUsuarioPorNombre(String nombre);
    
    public String buscarUsuarioPorEmailAndPasswd(String email, String passwd);
    
    public Usuario buscarUsuarioporNUsuario(String usuario);
    
    public Usuario buscarUsuarioporEmail(String email);
    
 /*   public List<Usuario> buscarUsuariosPorRol(Integer idRol);*/
    
    public List<Usuario> buscarUsuariosPorFlagDef(boolean flag) ;
    
    public boolean guardarUsuario(Usuario usuario);
  /*  public boolean guardarUsuario(String name, String email, String passwd, Integer idRol);*/

    
    public boolean eliminarUsuario(String email);

    
    public boolean actualizarUsuario(Usuario usuario);

    public boolean aprobarUsuario(Usuario usuario);
    
}
