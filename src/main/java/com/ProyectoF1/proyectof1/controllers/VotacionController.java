package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.model.Recuento;
import com.ProyectoF1.proyectof1.model.Votacion;
import com.ProyectoF1.proyectof1.model.Voto;
import com.ProyectoF1.proyectof1.service.IVotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("votaciones")
public class VotacionController {

    @Autowired
    IVotacionService votacionesService;

    @GetMapping("/all")
    public List<Votacion> buscarTodas(){
       
        return votacionesService.buscarTodas();
    }

    @GetMapping("/find/{id}")
    public Votacion buscarVotacionPorid(@PathVariable("id")Integer id){
        return votacionesService.buscarVotacionPorid(id);
    }

    @PostMapping("/save")
    public boolean crearVotacion(@RequestBody Votacion votacion){
        
 System.out.println("PASA POR VOTACIONES CONTROLLER");
        return votacionesService.guardarVotacion(votacion);
    }

    @PutMapping("/update")
    public boolean actualizarVotacion(@RequestBody Votacion votacion) {

        return votacionesService.actualizarVotacion(votacion);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteUserById(@PathVariable("id") Integer id){
          
        return votacionesService.eliminarVotacion(id);
    }
    @PostMapping("/votar/{idVotacion}")
    public boolean votar(@RequestBody Voto voto, @PathVariable("idVotacion") Integer idVotacion){

        return votacionesService.votar(idVotacion,voto);
    }
    @GetMapping("/resultados/{idVotacion}")
    public List<Recuento> resultadosVotacion(@PathVariable("idVotacion") Integer idVotacion){
        System.out.println("com.ProyectoF1.proyectof1.controllers.VotacionController.resultadosVotacion()");
        return votacionesService.recuento(idVotacion);
    }
}
