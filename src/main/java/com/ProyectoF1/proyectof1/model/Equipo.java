package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tbl_equipo",schema="uah_mad_g5")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipo", nullable = false)
    private Integer id;


    @Column(name = "logo", nullable = false, columnDefinition = "LONGTEXT")
    private String logo;
    
     @Column(name = "bandera", nullable = false, columnDefinition = "LONGTEXT")
    private String bandera;

    @Column(name = "twitter", length = 50)
    private String twitter;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "base", length = 50)
    private String base;

    @Column(name = "Team_Chief", length = 50)
    private String teamChief;

    @Column(name = "Tech_Chief", length = 50)
    private String techChief;


    @OneToMany(mappedBy = "equipo", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("equipo")
    private List<Piloto> Pilotos = new ArrayList<>();


    @OneToMany(mappedBy = "Equipo")
    @JsonIgnoreProperties("equipo")
    private List<Coche> Coches = new ArrayList<>();
    
    @OneToMany(mappedBy = "idEquipo")
    @JsonIgnoreProperties("equipo")
    private List<Usuario> users;

    private static final int MAX_PILOTOS = 2;
    private static final int MAX_COCHES = 4;

    public Equipo(String logo, String bandera, String twitter, String nombre, String base, String teamChief, String techChief) {
        this.logo = logo;
        this.bandera = bandera;
        this.twitter = twitter;
        this.nombre = nombre;
        this.base = base;
        this.teamChief = teamChief;
        this.techChief = techChief;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

  

    public Equipo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTeamChief() {
        return teamChief;
    }

    public void setTeamChief(String teamChief) {
        this.teamChief = teamChief;
    }

    public String getTechChief() {
        return techChief;
    }

    public void setTechChief(String techChief) {
        this.techChief = techChief;
    }

    public List<Piloto> getPilotos() {
        return Pilotos;
    }

    public void setPilotos(List<Piloto> tblPilotos) {
        this.Pilotos = tblPilotos;
    }

    public void setPiloto(Piloto piloto){
        if (this.Pilotos.size()<MAX_PILOTOS){
            this.Pilotos.add(piloto);
        }
    }

    public void deletePiloto(Integer idPiloto){
        if (!Pilotos.isEmpty()){
            for (Piloto piloto: this.Pilotos){
                if(piloto.getId()==idPiloto){
                    this.Pilotos.remove(piloto);
                    return;
                }
            }}
    }
    public List<Coche> getCoches() {
        return Coches;
    }

    public void setCoche(Coche coche){
        if (this.Coches.size()<MAX_COCHES){
            this.Coches.add(coche);
        }
    }

    public void deleteCoche(Integer idCoche){
        if (!Coches.isEmpty()){
            this.Coches.removeIf(coche -> coche.getId() == idCoche);
        }
    }

    public void setCoches(List<Coche> tblCoches) {
        this.Coches = tblCoches;
    }

    public boolean isPilotoinEquipo(Integer idPiloto) {
        if (!Pilotos.isEmpty()) {
            for (Piloto piloto : this.Pilotos) {
                if (piloto.getId() == idPiloto) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipoAux = (Equipo) o;
        return (Objects.equals(id, equipoAux.id) && Objects.equals(nombre, equipoAux.nombre)&&
                Objects.equals(teamChief, equipoAux.teamChief)&& Objects.equals(techChief, equipoAux.techChief)
                && Objects.equals(bandera, equipoAux.bandera));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, teamChief, techChief, bandera);
    }

    public boolean isCocheinEquipo(Integer idCoche) {
        if (!Coches.isEmpty()) {
            for (Coche coche : this.Coches) {
                if (coche.getId() == idCoche) {
                    return true;
                }
            }
        }
        return false;
    }
}