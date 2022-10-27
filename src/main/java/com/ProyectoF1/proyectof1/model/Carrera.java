/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gregsoft
 */
@Entity
public class Carrera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha;
    private Long idCircuito;

    public Carrera() {
    }

    public Carrera(Long id, Timestamp fecha, Long idCircuito) {
        this.id = id;
        this.fecha = fecha;
        this.idCircuito = idCircuito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Long getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(Long idCircuito) {
        this.idCircuito = idCircuito;
    }
    
    
}
