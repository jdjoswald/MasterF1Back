package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "usuario", nullable = false, length = 45)
    private String usuario;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idRol", nullable = false)
    @JsonIgnoreProperties("tbl_usuario")
    private Rol idRol;

    @Column(name = "definitivo", nullable = false)
    private boolean definitivo;

    public Usuario(){}

    public Usuario(String name, String email, String contrasena, Rol idRol) {
        this.nombre = name;
        this.email = email;
        this.contrasena = contrasena;
        this.idRol = idRol;
        this.definitivo = false;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public boolean getDefinitivo() {
        return definitivo;
    }

    public void setDefinitivo(boolean definitivo) {
        this.definitivo = definitivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return (Objects.equals(id, usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(usuario, usuario.usuario) &&
                Objects.equals(email, usuario.email) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(idRol, usuario.idRol));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, usuario, email, contrasena,idRol);
    }

}