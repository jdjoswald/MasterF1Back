/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Noticia;
import java.util.List;

/**
 *
 * @author joswald
 */
public interface INoticiaDAO {
    List<Noticia> buscarTodos();
    Noticia buscarPorId(Integer idNoticia);
    void guardarNoticia(Noticia noticia);
    void actualizarNoticia(Noticia noticia);
    void eliminarNoticia(Integer idNoticia);
    
}
