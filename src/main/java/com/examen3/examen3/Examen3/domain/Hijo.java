package com.examen3.examen3.Examen3.domain;

import javax.persistence.*;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String plan;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HIJO_ID", referencedColumnName = "ID")
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

    public Hijo(Long id, String nombre, String plan, Encargado encargado) {
        this.id = id;
        this.nombre = nombre;
        this.plan = plan;
        this.encargado = encargado;
    }

    public Hijo() {
    }
}
