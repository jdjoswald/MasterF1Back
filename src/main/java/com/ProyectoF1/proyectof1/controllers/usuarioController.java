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
    IUsuarioService IUsuarioService;
    
    @GetMapping("/all")
    public List<Usuario> buscarTodos(){
        return IUsuarioService.buscarTodos();
    }

    @GetMapping("/find/{id}")
    public Usuario buscarUsuarioPorid(@PathVariable("id")Integer id){
    return IUsuarioService.buscarUsuarioPorid(id);
    }


    @GetMapping("/find/{email}")
    public Usuario buscarUsuarioPorEmail(@PathVariable("email")String email){
    return IUsuarioService.buscarUsuarioporEmail(email);
    }

    @GetMapping("/login/{email}/{passwd}")
    public boolean login(@PathVariable("email")String email, @PathVariable("passwd")String passwd){
        if (IUsuarioService.buscarUsuarioPorEmailAndPasswd(email, passwd)!= null){
            return true;
        };
        return false;
    }

    @PostMapping("/save")
    public boolean crearUsuario(@RequestBody Usuario usuario){
       return IUsuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/save")
    public boolean actualizarCurso(@RequestBody Usuario usuario) {
        return IUsuarioService.actualizarUsuario(usuario);
    }

    @DeleteMapping ("/delete/{email}")
    public boolean deleteUserById(@PathVariable("email") String email){
       return IUsuarioService.eliminarUsuario(email);
    }


    
}
