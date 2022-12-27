package com.ProyectoF1.proyectof1.controllers;

import com.ProyectoF1.proyectof1.model.Equipo;
import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.service.IPilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("pilotos")
@CrossOrigin
public class pilotosController {

    @Autowired
    IPilotoService pilotosService;

    @GetMapping("/all")
    public List<Piloto> buscarTodos(){
        return pilotosService.buscarTodos();
    }

    @GetMapping("/find/id/{id}")
    public Piloto buscarPilotoPorid(@PathVariable("id")Integer id){
        return pilotosService.buscarPilotoPorid(id);
    }

    @GetMapping("/find/nombre/{name}")
    public List<Piloto> buscarPilotoPorNombre(@PathVariable("name")String nombre){
        return pilotosService.buscarPilotoPorNombre(nombre);}

    @GetMapping("/find/apellido/{apellidos}")
    public List<Piloto> buscarPilotoPorApellidos(@PathVariable("apellidos")String apellidos){
        return pilotosService.buscarPilotoPorApellidos(apellidos);}

    @GetMapping("/find/nombreApellidos/{nombre}/{apellidos}")
    public Piloto buscarPilotoPorNombreApellidos(@PathVariable("nombre")String nombre, @PathVariable("apellidos")String apellidos){
        return pilotosService.buscarPilotoPorNombreApellidos(nombre,apellidos);}

    @GetMapping("/find/siglas/{siglas}")
    public Piloto buscarPilotoPorIniciales(@PathVariable("siglas")String siglas){
        return pilotosService.buscarPilotoPorSiglas(siglas);}

    @GetMapping("/find/pais/{pais}")
    public List<Piloto> buscarPilotoPorPais(@PathVariable("pais")String pais){
        return pilotosService.buscarPilotoPorPais(pais);}

    @PostMapping("/save")
    public boolean crearPiloto(@RequestBody Piloto piloto){
        return pilotosService.guardarPiloto(piloto);
    }

    @PutMapping("/update")
    public boolean actualizarPiloto(@RequestBody Piloto piloto) {
        return pilotosService.actualizarPiloto(piloto);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deletePilotoById(@PathVariable("id") Integer idPiloto){
        System.out.println("Pasa por controller");
        return pilotosService.eliminarPiloto(idPiloto);

    }

    @GetMapping(value="/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] buscarPilotoimg(@PathVariable("id") int idPiloto) throws IOException {
        return pilotosService.buscarPilotoimg(idPiloto);}

}
