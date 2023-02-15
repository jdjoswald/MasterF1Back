package com.ProyectoF1.proyectof1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    @Column(name = "contrasena", length = 50)
    private String contrasena;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idRol",referencedColumnName = "idRol", nullable = true)
    @JsonIgnoreProperties("tbl_usuario")
    private Rol id_Rol;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idEquipo",referencedColumnName = "idEquipo")
    @JsonIgnoreProperties("users")
    private Equipo idEquipo;

    @OneToMany(mappedBy = "Usuario", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value = {"Usuario"})
    //@JsonIgnore
    private List<Votacion> votaciones;

    @Column(name = "definitivo", nullable = false)
    private boolean definitivo;

    @OneToMany(mappedBy = "idUsuario")
    @JsonIgnoreProperties("tbl_usuario")
    private List<Noticia> noticia;

    public Usuario(){}


    public Usuario(String nombre, String usuario, String email, String contrasena, Rol id_Rol, Equipo idEquipo, boolean definitivo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.id_Rol = id_Rol;

        this.idEquipo = idEquipo;
        this.definitivo = definitivo;
    }
    

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
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
    @JsonIgnore
    @JsonProperty(value = "contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(Rol idRol) {
        this.id_Rol = idRol;
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
                Objects.equals(email, usuario.email) && Objects.equals(contrasena, usuario.contrasena) && Objects.equals(id_Rol, usuario.id_Rol));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, usuario, email, contrasena, id_Rol);
    }

}