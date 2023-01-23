package com.ProyectoF1.proyectof1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tbl_voto")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVoto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idVotacion", nullable = false)
    @JsonIgnoreProperties("votos")
    Votacion idVotacion;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "idPiloto", nullable = false)
    private Integer idPiloto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Votacion getIdVotacion() {
        return idVotacion;
    }

    public void setIdVotacion(Votacion idVotacion) {
        this.idVotacion = idVotacion;
    }

    @JsonIgnore
    @JsonProperty(value = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    @JsonProperty(value = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(Integer idPiloto) {
        this.idPiloto = idPiloto;
    }

}