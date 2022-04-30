package com.examen3.examen3.Examen3.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private boolean guarderia;
    private boolean lectura;
    private String alergias;
    private Long idEncargado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HIJO_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Encargado encargado;

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

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Hijo() {
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Hijo(Long id, String nombre, boolean guarderia, boolean lectura, String alergias, Long idEncargado, Encargado encargado) {
        this.id = id;
        this.nombre = nombre;
        this.guarderia = guarderia;
        this.lectura = lectura;
        this.alergias = alergias;
        this.idEncargado = idEncargado;
        this.encargado = encargado;
    }

    public Long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Long idEncargado) {
        this.idEncargado = idEncargado;
    }

    public boolean isGuarderia() {
        return guarderia;
    }

    public void setGuarderia(boolean guarderia) {
        this.guarderia = guarderia;
    }

    public boolean isLectura() {
        return lectura;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    @JsonIgnore
    public boolean isNull(){
        return encargado == null;
    }
}
