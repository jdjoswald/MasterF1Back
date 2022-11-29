package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol", nullable = false)
    private Integer id;

    @Column(name = "rol", nullable = false, length = 45)
    private String rol;

    @OneToMany(mappedBy = "id_Rol", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"tbl_rol"})
    private List<Usuario> users;
    public Integer getId() {
        return id;
    }

    public Rol(String rol) {
        this.rol = rol;
    }

    public Rol() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rolAux = (Rol) o;
        return (Objects.equals(id, rolAux.id) && Objects.equals(rol, rolAux.rol));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol);
    }

}