/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class usuarioController {
    @Autowired
    IUsuarioService UsuarioService;
    
    @GetMapping("/all")
    public List<Usuario> buscarTodos(){
        return UsuarioService.buscarTodos();
    }

    @GetMapping("/find/{id}")
    public Usuario buscarUsuarioPorid(@PathVariable("id")Integer id){
    return UsuarioService.buscarUsuarioPorid(id);
    }

    @GetMapping("/find/users/{aprobados_flag}")
    public List<Usuario> buscarUsuariosPorFlagDe(@PathVariable("aprobados_flag")boolean flag){
        return UsuarioService.buscarUsuariosPorFlagDef(flag);
    }


    @GetMapping("/find/{email}")
    public Usuario buscarUsuarioPorEmail(@PathVariable("email")String email){
    return UsuarioService.buscarUsuarioporEmail(email);
    }

    @GetMapping("/login/{email}/{passwd}")
    public String login(@PathVariable("email")String email, @PathVariable("passwd")String passwd){
        return  UsuarioService.buscarUsuarioPorEmailAndPasswd(email, passwd);
      }

    @PostMapping("/save")
    public boolean crearUsuario(@RequestBody Usuario usuario){
          return UsuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/save")
    public boolean actualizarUsuario(@RequestBody Usuario usuario) {
        return UsuarioService.actualizarUsuario(usuario);
    }

    @PutMapping("/aprobarUsuarios")
    public boolean aprobarUsuario(@RequestBody Usuario usuario) {
        return UsuarioService.aprobarUsuario(usuario);
    }

    @DeleteMapping ("/delete/{email}")
    public boolean deleteUserById(@PathVariable("email") String email){
       return UsuarioService.eliminarUsuario(email);
    }


    
}
