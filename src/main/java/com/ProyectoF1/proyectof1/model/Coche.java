package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_coche")
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoche", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "codigo", nullable = false, length = 45)
    private String codigo;

    @Column(name = "ersCurvaLenta", length = 45)
    private double ersCurvaLenta;

    @Column(name = "ersCurvaMedia", length = 45)
    private double ersCurvaMedia;

    @Column(name = "ersCurvaRapida", length = 45)
    private double ersCurvaRapida;

    @Column(name = "consumo", length = 45)
    private double consumo;
    
     @Column(name = "foto", nullable = true, columnDefinition = "LONGTEXT")
    private String foto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEquipo",referencedColumnName = "idEquipo", nullable = true)
    @JsonIgnoreProperties("coches")
    private Equipo Equipo;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
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

    public double getErsCurvaLenta() {
        return ersCurvaLenta;
    }

    public void setErsCurvaLenta(double ersCurvaLenta) {
        this.ersCurvaLenta = ersCurvaLenta;
    }

    public double getErsCurvaMedia() {
        return ersCurvaMedia;
    }

    public void setErsCurvaMedia(double ersCurvaMedia) {
        this.ersCurvaMedia = ersCurvaMedia;
    }

    public double getErsCurvaRapida() {
        return ersCurvaRapida;
    }

    public void setErsCurvaRapida(double ersCurvaRapida) {
        this.ersCurvaRapida = ersCurvaRapida;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return (Objects.equals(id, coche.id) && Objects.equals(nombre, coche.nombre) && Objects.equals(codigo, coche.codigo) &&
                Objects.equals(ersCurvaLenta, coche.ersCurvaLenta) && Objects.equals(ersCurvaMedia, coche.ersCurvaMedia) &&
                Objects.equals(ersCurvaRapida, coche.ersCurvaRapida) && Objects.equals(consumo, coche.consumo)
                && Objects.equals(Equipo, coche.Equipo));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, codigo, ersCurvaLenta, ersCurvaMedia, ersCurvaRapida,consumo,Equipo);
    }

}