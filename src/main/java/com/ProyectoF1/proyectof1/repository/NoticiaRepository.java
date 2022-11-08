/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoF1.proyectof1.repository;

import com.ProyectoF1.proyectof1.model.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joswald
 */
@Repository
public interface NoticiaRepository extends CrudRepository<Noticia, Integer>{
    
}
