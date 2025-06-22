package com.example.practica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Clientes
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 125)
    private String nombre;
    @Column(name = "cedula", nullable = false, length = 11,unique = true)
    private String cedula;


    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medidores> medidores;

    public Clientes() {
    }

    public Clientes(Integer id, String nombre, String cedula, List<Medidores> medidores) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.medidores = medidores;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Medidores> getMedidores() {
        return medidores;
    }

    public void setMedidores(List<Medidores> medidores) {
        this.medidores = medidores;
    }
}
