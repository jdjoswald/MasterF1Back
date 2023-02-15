package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tbl_piloto")

public class Piloto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPiloto", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "siglas", length = 45)
    private String siglas;

    @Column(name = "dorsal", length = 45)
    private String dorsal;


    @Column(name = "foto", nullable = false, columnDefinition = "LONGTEXT")
    private String foto;

    @Column(name = "pais", length = 120)
    private String pais;

      @Column(name = "bandera", columnDefinition = "LONGTEXT")
    private String bandera;


    @Column(name = "twitter", length = 45)
    private String twitter;



    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idEquipo",referencedColumnName = "idEquipo" )
    @JsonIgnoreProperties(value = {"Pilotos"}, allowSetters = true)
    @JsonBackReference
   // @JsonIgnore
    private Equipo equipo;
    
     @ManyToMany(mappedBy = "pilotos", 
                fetch = FetchType.EAGER, 
                cascade = CascadeType.ALL)
    //@JsonIgnoreProperties(value = {"pilotos"}, allowSetters = true)
    //@JsonIgnore 
    //@JsonBackReference
    List<Votacion> votacion;

    public Piloto(String nombre, String apellidos, String siglas, String dorsal, String foto, String pais, String twitter) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.siglas = siglas;
        this.dorsal = dorsal;
        this.foto = foto;
        this.pais = pais;
       
        this.twitter = twitter;
    }

    public Piloto(Integer id) {
        this.id = id;
    }
    


    public Piloto() {
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public List<Votacion> getVotacion() {
        return votacion;
    }

    public void setVotacion(List<Votacion> votacion) {
        this.votacion = votacion;
    }



    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
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

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Equipo getEquipo() { return equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return (Objects.equals(id, piloto.id) && Objects.equals(nombre, piloto.nombre) && Objects.equals(apellidos, piloto.apellidos) &&
                 Objects.equals(siglas, piloto.siglas) && Objects.equals(pais, piloto.pais));
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, siglas, pais);
    }

}