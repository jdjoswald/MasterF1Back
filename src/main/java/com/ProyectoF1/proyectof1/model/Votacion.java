/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author joswald
 */
@Entity
public class Votacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permalink;
    private String titulo;
    private String descripcion;
    private Long idUsuario;
    private Timestamp fechaInicio;
    private Timestamp fechaCulminacion;
    
    public Votacion(){}

    public Votacion(Long id, String permalink, String titulo, String descripcion, Long idUsuario, Timestamp fechaInicio, Timestamp fechaCulminacion) {
        this.id = id;
        this.permalink = permalink;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaCulminacion = fechaCulminacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(Timestamp fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }
    
    
     
    
    
    
}
