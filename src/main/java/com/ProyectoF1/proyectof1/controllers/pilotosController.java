package com.ProyectoF1.proyectof1.controllers;


import com.ProyectoF1.proyectof1.model.Piloto;
import com.ProyectoF1.proyectof1.service.IPilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("pilotos")
public class pilotosController {

    @Autowired
    IPilotoService pilotosService;

    @GetMapping("/all")
    public List<Piloto> buscarTodos(){
        return pilotosService.buscarTodos();
    }

    @GetMapping(value="/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] buscarEquipoimg(@PathVariable("id") int idPiloto) throws IOException {
        return pilotosService.buscarPilotoimg(idPiloto);}

}
