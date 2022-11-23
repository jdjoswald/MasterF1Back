/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Gregsoft
 */
@Entity
public class Piloto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  nombre;
    private String apellidos;
    private String siglas;
    private int dorsal;
    private String foto;
    private String pais;
    private Long idEquipo;
    @ManyToMany(mappedBy = "pilotos", 
                fetch = FetchType.LAZY, 
                cascade = CascadeType.ALL)
    @JsonBackReference
    Set<Carrera> carreras;

    public Piloto() {
    }

    public Piloto(String nombre, String apellidos, String siglas, int dorsal, String foto, String pais, Long idEquipo) {
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.siglas = siglas;
        this.dorsal = dorsal;
        this.foto = foto;
        this.pais = pais;
        this.idEquipo = idEquipo;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }
    
    
}
