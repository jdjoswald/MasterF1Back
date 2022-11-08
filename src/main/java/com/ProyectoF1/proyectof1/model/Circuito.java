/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gregsoft
 */
@Entity
public class Circuito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre; 
    private String ciudad;
    private String pais;
    private String trazado;
    private int numeroVueltas;
    private double longitud;
    private int curvasLentas;
    private int curvasMedia;
    private int curvasRapidas;

    public Circuito() {
    }

    public Circuito(String nombre, String ciudad, String pais, String trazado, int numeroVueltas, double longitud, int curvasLentas, int curvasMedia, int curvasRapidas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.trazado = trazado;
        this.numeroVueltas = numeroVueltas;
        this.longitud = longitud;
        this.curvasLentas = curvasLentas;
        this.curvasMedia = curvasMedia;
        this.curvasRapidas = curvasRapidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTrazado() {
        return trazado;
    }

    public void setTrazado(String trazado) {
        this.trazado = trazado;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCurvasLentas() {
        return curvasLentas;
    }

    public void setCurvasLentas(int curvasLentas) {
        this.curvasLentas = curvasLentas;
    }

    public int getCurvasMedia() {
        return curvasMedia;
    }

    public void setCurvasMedia(int curvasMedia) {
        this.curvasMedia = curvasMedia;
    }

    public int getCurvasRapidas() {
        return curvasRapidas;
    }

    public void setCurvasRapidas(int curvasRapidas) {
        this.curvasRapidas = curvasRapidas;
    }
    
    
}
