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
 * @author joswald
 */
@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigo;
    private Double ersCurvaLenta;
    private Double ersCurvaMedia;
    private Double ersCurvaRapida;
    private Double consumo;
    private Long idEquipo;
    
    public Coche(){}

    public Coche(Long id, String nombre, String codigo, Double ersCurvaLenta, Double ersCurvaMedia, Double ersCurvaRapida, Double consumo, Long idEquipo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ersCurvaLenta = ersCurvaLenta;
        this.ersCurvaMedia = ersCurvaMedia;
        this.ersCurvaRapida = ersCurvaRapida;
        this.consumo = consumo;
        this.idEquipo = idEquipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getErsCurvaLenta() {
        return ersCurvaLenta;
    }

    public void setErsCurvaLenta(Double ersCurvaLenta) {
        this.ersCurvaLenta = ersCurvaLenta;
    }

    public Double getErsCurvaMedia() {
        return ersCurvaMedia;
    }

    public void setErsCurvaMedia(Double ersCurvaMedia) {
        this.ersCurvaMedia = ersCurvaMedia;
    }

    public Double getErsCurvaRapida() {
        return ersCurvaRapida;
    }

    public void setErsCurvaRapida(Double ersCurvaRapida) {
        this.ersCurvaRapida = ersCurvaRapida;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }
    
}
