package com.examen3.examen3.Examen3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Encargado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefonoUno;
    private String telefonoDos;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "HIJO_ID", referencedColumnName = "ID")
    private List<Hijo> hijos;

    public Encargado(Long id, String nombre, String cedula, String direccion, String telefonoUno, String telefonoDos) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Hijo> hijos) {
        this.hijos = hijos;
    }

    public Encargado() {
    }

    public String getTelefonoDos() {
        return telefonoDos;
    }

    public void setTelefonoDos(String telefono_dos) {
        this.telefonoDos = telefono_dos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoUno() {
        return telefonoUno;
    }

    public void setTelefonoUno(String telefono_uno) {
        this.telefonoUno = telefono_uno;
    }

    @JsonIgnore
    public boolean isNull(){
        return id == null && nombre == null && cedula == null && direccion == null && telefonoUno == null && telefonoDos == null;
    }
}
