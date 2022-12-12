/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.DAO;

import com.ProyectoF1.proyectof1.model.Noticia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public class NoticiaDaoImpl implements INoticiaDAO{
    @Autowired
    INoticiaJPA noticiaJPA;

    @Override
    public List<Noticia> buscarTodos() {
       return noticiaJPA.findAll();    }

    @Override
    public Noticia buscarPorId(Integer idNoticia) {
        
        Optional<Noticia> optional = noticiaJPA.findById(idNoticia); 
        if (optional.isPresent()) {
        return optional.get();
        }
        return null;
    }

    @Override
    public void guardarNoticia(Noticia noticia) {
        noticiaJPA.save(noticia);
    }

    @Override
    public void actualizarNoticia(Noticia noticia) {
        noticiaJPA.save(noticia);
    }

    @Override
    public void eliminarNoticia(Integer idNoticia) {
      /*  Noticia noti=buscarPorId(idNoticia);
        noti.setIdUsuario(null);
        guardarNoticia(noti);*/
        noticiaJPA.deleteById(idNoticia);
    }
    
}
