/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Rol;
import com.ProyectoF1.proyectof1.model.Usuario;
import com.ProyectoF1.proyectof1.service.IEquipoService;
import com.ProyectoF1.proyectof1.service.IRolesService;
import com.ProyectoF1.proyectof1.service.IUsuarioService;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("user")
public class usuarioController {
    @Autowired
    IUsuarioService UsuarioService;
    @Autowired
    IRolesService RolService;
     @Autowired
     IEquipoService EquipoService;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<Usuario> buscarTodos(){
        return UsuarioService.buscarTodos();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/{id}")
    public Usuario buscarUsuarioPorid(@PathVariable("id")Integer id){
    return UsuarioService.buscarUsuarioPorid(id);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/users/{aprobados_flag}")/* Si busca no validados pasar false, si busca validados pasar true*/
    public List<Usuario> buscarUsuariosPorFlagDe(@PathVariable("aprobados_flag")boolean flag){
        return UsuarioService.buscarUsuariosPorFlagDef(flag);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/find/email/{email}")
    public Usuario buscarUsuarioPorEmail(@PathVariable("email")String email){
    return UsuarioService.buscarUsuarioporEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login/{email}/{passwd}")
    public Usuario login(@PathVariable("email")String email, @PathVariable("passwd")String passwd){
        return  UsuarioService.buscarUsuarioPorEmailAndPasswd(email, passwd);
      }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public boolean crearUsuario(@RequestBody Usuario usuario){
           Rol rol= RolService.buscarPorId(usuario.getId_Rol().getId());
        System.out.println(rol.getId());
        usuario.setId_Rol(rol);
          return UsuarioService.guardarUsuario(usuario);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update")
    public boolean actualizarUsuario(@RequestBody Usuario usuario) {
        Rol rol= RolService.buscarPorId(usuario.getId_Rol().getId());
        System.out.println(rol.getId());
        usuario.setId_Rol(rol);
        return UsuarioService.actualizarUsuario(usuario);
    }
    
      @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update2")
    public boolean actualizarUsuarioSinCOntrasenna(@RequestBody Usuario usuario) {
        Rol rol= RolService.buscarPorId(usuario.getId_Rol().getId());
        System.out.println(rol.getId());
        usuario.setId_Rol(rol);
        String oldpassword = UsuarioService.buscarUsuarioPorid(usuario.getId()).getContrasena();
        usuario.setContrasena(oldpassword);
        return UsuarioService.actualizarUsuario(usuario);
    }
    
    @PutMapping("/linkteam/{id}/{idTeam}")
    public boolean linkTeam(@PathVariable("id") Integer id,@PathVariable("idTeam") Integer idTeam) {
       Usuario usuario= UsuarioService.buscarUsuarioPorid(id);
       usuario.setIdEquipo(EquipoService.buscarEquipoPorId(idTeam));
        return UsuarioService.actualizarUsuario(usuario);
    }
    @CrossOrigin(origins = "http://localhost:3000")

    @PutMapping("/aprobarUsuario/{id}")
    public boolean aprobarUsuario(@PathVariable("id") Integer id) {
        return UsuarioService.aprobarUsuario(id);}

    @PutMapping("/delTeam/{id}")
    public boolean delTeam(@PathVariable("id")Integer id) {
        
      Usuario usuario =UsuarioService.buscarUsuarioPorid(id);
      usuario.setIdEquipo(null);
      
      return UsuarioService.actualizarUsuario(usuario);
    }
   
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping ("/delete/{email}")
    public boolean deleteUserById(@PathVariable("email") String email){
       return UsuarioService.eliminarUsuario(email);
    }


    
}
