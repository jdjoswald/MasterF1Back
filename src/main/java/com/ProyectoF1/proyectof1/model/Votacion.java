package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_votacion")
public class Votacion implements Serializable {
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

    @ManyToOne(optional = true)
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario", nullable = true)
    @JsonIgnoreProperties("tbl_votacion")
    private Usuario Usuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_votacion_piloto", joinColumns = {
            @JoinColumn(name = "idVotacion", referencedColumnName = "idVotacion")}, inverseJoinColumns = {
            @JoinColumn(name = "idPiloto", referencedColumnName = "idPiloto")})
    
    private List<Piloto> pilotos;

    @OneToMany(mappedBy = "idVotacion")
    @JsonIgnoreProperties("idVotacion")
    
    private List<Voto> votos;

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

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario idUsuario) {
        this.Usuario = idUsuario;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> tblPilotos) {
        this.pilotos = tblPilotos;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> Votos) {
        this.votos = votos;
    }

    public void addVoto(Voto voto){
        this.votos.add(voto);
    }

    public boolean isPilotoInVotacion(Integer idPiloto) {
        boolean resultado = false;
        int numPilotos = pilotos.size();
        for (int i = 0; i < numPilotos && resultado == false; i++) {
            if (pilotos.get(i).getId() == idPiloto) {
                resultado = true;
            }
        }
        return resultado;
    }

}