/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Gregsoft
 */
@Entity
@Table(name="Tbl_Carrera")
public class Carrera {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrera", nullable = false)
    private Integer id;
    @Column(name = "fecha", nullable = false, length = 150)
    private String fecha;
     @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "circuitoId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties("Tbl_Carrera")
    private Circuito circuito;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Tbl_carrera_piloto", 
               joinColumns = { @JoinColumn( name="fk_carrera") },
               inverseJoinColumns = { @JoinColumn(name = "fk_piloto") })  
    //@JsonIgnoreProperties("fk_pelicula")
    @JsonBackReference
    Set<Piloto> pilotos;

    public Carrera() {
    }

    public Carrera(String fecha, String nombre, Circuito circuito) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.circuito = circuito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public Set<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(Set<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    
    
    
    
    

    
    
    
}
