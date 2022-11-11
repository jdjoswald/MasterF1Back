/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.DAO.INoticiaDAO;
import com.ProyectoF1.proyectof1.model.Noticia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class NoticiaServiceImpl implements INoticiaService{
    
    @Autowired
    INoticiaDAO noticiaDAO;

    @Override
    public List<Noticia> buscarTodos() {
        return noticiaDAO.buscarTodos();  }

    @Override
    public Noticia buscarPorId(Integer idNoticia) {
        return noticiaDAO.buscarPorId(idNoticia);
    }

    @Override
    public Noticia guardarNoticia(Noticia noticia) {
         noticiaDAO.guardarNoticia(noticia);
          return noticia;
    }

    @Override
    public void actualizarNoticia(Noticia noticia) {
        noticiaDAO.actualizarNoticia(noticia);
    }

    @Override
    public boolean eliminarNoticia(Integer idNoticia) {
        noticiaDAO.eliminarNoticia(idNoticia);
        return true;
    }
    

    
}
