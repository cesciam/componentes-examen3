package com.examen3.examen3.Examen3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "activo", nullable = false)
    private boolean activo;

    @Column(name = "lectores", nullable = true)
    @ManyToMany(mappedBy = "librosLeidos")
    @JsonIgnore
    private List<Hijo> lectores;

    public Libro() {
    }

    public List<Hijo> getLectores() {
        return lectores;
    }

    public void setLectores(List<Hijo> lectores) {
        this.lectores = lectores;
    }

    public Libro(int id, String nombre, boolean activo, List<Hijo> lectores) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
        this.lectores = lectores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
