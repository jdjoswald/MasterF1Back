/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.service;

import com.ProyectoF1.proyectof1.model.Noticia;
import com.ProyectoF1.proyectof1.repository.NoticiaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joswald
 */
@Service
public class NoticiaSeviceImpl implements NoticiaService{
    @Autowired
    NoticiaRepository noticiaRepository;

    @Override
    public ArrayList<Noticia> getAllNoticia() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return (ArrayList<Noticia>) noticiaRepository.findAll();
    }

    @Override
    public Optional<Noticia> getNoticiaById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (Optional<Noticia>) noticiaRepository.findById(id);
    }

    @Override
    public boolean saveNoticia(Noticia u) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       
        
        try {
            noticiaRepository.save(u);
            return true;
            
        } catch (Exception e) {
        return false;
        }     
    }

    @Override
    public boolean deleteNoticiaById(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            Optional<Noticia> u = getNoticiaById(id);
            noticiaRepository.delete(u.get());
            return true;
            
        } catch (Exception e) {
        return false;
        }      
    }
    
}
