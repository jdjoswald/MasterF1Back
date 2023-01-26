package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.service.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("equipos")

@CrossOrigin

public class equiposController {

    @Autowired
    IEquipoService equiposService;

    @GetMapping("/all")
    public List<Equipo> buscarTodos(){
        return equiposService.buscarTodos();
    }

    @GetMapping("/find/id/{id}")
    public Equipo buscarEquipoPorid(@PathVariable("id")Integer id){
        return equiposService.buscarEquipoPorId(id);
    }

    @GetMapping("/find/nombre/{nombre}")
    public Equipo buscarEquipoPorNombre(@PathVariable("nombre")String nombre){
        return equiposService.buscarEquipoPorNombre(nombre);
    }
    @GetMapping("/find/base/{base}")
    public List<Equipo> buscarEquipoPorBase(@PathVariable("base")String base){
        return equiposService.buscarEquipoPorBase(base);
    }
    @PostMapping("/save/{id}")
    public Equipo crearEquipo(@RequestBody Equipo equipo){
        return equiposService.guardarEquipo(equipo);
    }

    @PutMapping("/update")
    public boolean actualizarEquipo(@RequestBody Equipo equipo) {
        return equiposService.actualizarEquipo(equipo);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteEquipoById(@PathVariable("id") Integer idEquipo){
        return equiposService.eliminarEquipo(idEquipo);
    }

    @GetMapping(value="/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] buscarEquipoimg(@PathVariable ("id") int idEquipo) throws IOException {
        return equiposService.buscarEquipoimg(idEquipo);}


}
