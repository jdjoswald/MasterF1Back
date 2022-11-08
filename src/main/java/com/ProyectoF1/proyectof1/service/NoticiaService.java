/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Noticia;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author joswald
 */
public interface NoticiaService {
    ArrayList<Noticia> getAllNoticia();
    Optional<Noticia> getNoticiaById(Integer id);
    boolean saveNoticia(Noticia u);
    boolean deleteNoticiaById(Integer id);
    
}
