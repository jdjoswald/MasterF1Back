package com.ProyectoF1.proyectof1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rol")
public class Rol {
    @Id
    @Column(name = "idRol", nullable = false)
    private Integer id;

    @Column(name = "rol", nullable = false, length = 45)
    private String rol;

    public Integer getId() {
        return id;
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

}