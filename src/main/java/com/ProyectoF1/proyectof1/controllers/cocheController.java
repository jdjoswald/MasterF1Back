package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Coche;
import com.ProyectoF1.proyectof1.service.ICocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("coches")
@CrossOrigin
public class cocheController {

    @Autowired
    ICocheService cochesService;

    @GetMapping("/all")
    public List<Coche> buscarTodos(){
        return cochesService.buscarTodos();
    }

    @GetMapping("/find/id/{id}")
    public Coche buscarCochePorid(@PathVariable("id")Integer id){
        return cochesService.buscarCochePorid(id);
    }

    @GetMapping("/find/nombre/{name}")
    public List<Coche> buscarCochePorNombre(@PathVariable("name")String nombre){
        return cochesService.buscarCochePorNombre(nombre);}

    @GetMapping("/find/codigo/{codigo}")
    public Coche buscarCochePorCodigo(@PathVariable("codigo")String codigo){
        return cochesService.buscarCochePorCodigo(codigo);}


    @PostMapping("/save") ///* Codigo obligatorio!*//
    public boolean crearCoche(@RequestBody Coche coche){
        return cochesService.guardarCoche(coche);
    }

    @PutMapping("/update")//* Codigo e ID no se pueden cambiar*//
    public boolean actualizarCoche(@RequestBody Coche coche) {
        return cochesService.actualizarCoche(coche);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteCocheById(@PathVariable("id") Integer idCoche){
        return cochesService.eliminarCoche(idCoche);

    }

    @PutMapping("/update/equipo/{idCoche}/{idEquipo}")
    public boolean updateEquipo(@PathVariable("idCoche")Integer idCoche, @PathVariable("idEquipo")Integer idEquipo){
        return cochesService.addEquipo(idCoche,idEquipo);}




}
