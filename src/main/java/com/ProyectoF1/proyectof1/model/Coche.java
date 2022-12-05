package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tbl_coche")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoche", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEquipo", nullable = false)
    @JsonIgnoreProperties("tbl_coche")
    private Equipo Equipo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;

    @Column(name = "ersCurvaLenta", length = 45)
    private String ersCurvaLenta;

    @Column(name = "ersCurvaMedia", length = 45)
    private String ersCurvaMedia;

    @Column(name = "ersCurvaRapida", length = 45)
    private String ersCurvaRapida;

    @Column(name = "consumo", length = 45)
    private String consumo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo idEquipo) {
        this.Equipo = idEquipo;
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

    public String getErsCurvaLenta() {
        return ersCurvaLenta;
    }

    public void setErsCurvaLenta(String ersCurvaLenta) {
        this.ersCurvaLenta = ersCurvaLenta;
    }

    public String getErsCurvaMedia() {
        return ersCurvaMedia;
    }

    public void setErsCurvaMedia(String ersCurvaMedia) {
        this.ersCurvaMedia = ersCurvaMedia;
    }

    public String getErsCurvaRapida() {
        return ersCurvaRapida;
    }

    public void setErsCurvaRapida(String ersCurvaRapida) {
        this.ersCurvaRapida = ersCurvaRapida;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

}