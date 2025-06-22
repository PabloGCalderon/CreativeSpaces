package com.example.practica.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medidores")
public class Medidores
{
    @Id
    @Column(name = "numeroUnico",nullable = false,unique = true)
    private Integer numeroUnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @JsonIgnore
    @OneToMany(mappedBy = "medidores", cascade = CascadeType.ALL)
    private List<Facturas> facturas;

    public Medidores() {
    }

    public Medidores(Integer numeroUnico, Clientes clientes, List<Facturas> facturas) {
        this.numeroUnico = numeroUnico;
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public Integer getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(Integer numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Facturas> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Facturas> facturas) {
        this.facturas = facturas;
    }
}
