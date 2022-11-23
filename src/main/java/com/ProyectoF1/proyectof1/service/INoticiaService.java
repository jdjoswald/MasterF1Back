/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Noticia;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface INoticiaService {
    
    List<Noticia> buscarTodos();
    Noticia buscarPorId(Integer idNoticia);
    Noticia guardarNoticia(Noticia noticia);
    void actualizarNoticia(Noticia noticia);
    boolean eliminarNoticia(Integer idNoticia);
    
}
