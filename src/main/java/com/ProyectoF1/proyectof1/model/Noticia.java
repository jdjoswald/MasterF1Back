/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author joswald
 */
@Entity
@Table(name = "tbl_noticia")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "imagen", nullable = false, columnDefinition = "LONGTEXT")
    private String imagen;
    @Column(name = "texto", nullable = false)
    private String texto;
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idUsuario", nullable = false)
    
    @JsonIgnoreProperties("tbl_noticia")
    private Usuario idUsuario;

    public Noticia() {
    }

    public Noticia( String titulo, String imagen, String texto, Usuario idUsuario) {
        
        this.titulo = titulo;
        this.imagen = imagen;
        this.texto = texto;
        this.idUsuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noticia noticia = (Noticia) o;
        return (Objects.equals(id, noticia.id) && Objects.equals(titulo, noticia.titulo) && Objects.equals(imagen, noticia.imagen) &&
                Objects.equals(texto, noticia.texto) && Objects.equals(idUsuario, noticia.idUsuario) );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, imagen, texto, idUsuario);
    }
}
