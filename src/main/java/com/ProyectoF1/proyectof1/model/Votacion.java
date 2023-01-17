package com.ProyectoF1.proyectof1.model;

import com.ProyectoF1.proyectof1.model.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_votacion")
public class Votacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVotacion", nullable = false)
    private Integer id;

    @Column(name = "permalink", nullable = false, length = 250)
    private String permalink;

    @Column(name = "titulo", nullable = false, length = 120)
    private String titulo;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaCulminacion", nullable = false)
    private LocalDate fechaCulminacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaCulminacion() {
        return fechaCulminacion;
    }

    public void setFechaCulminacion(LocalDate fechaCulminacion) {
        this.fechaCulminacion = fechaCulminacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}