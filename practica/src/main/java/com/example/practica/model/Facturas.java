package com.example.practica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class Facturas
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroFactura;

    private String fechaEmision;

    private Double consumo;

    private Double totalPagar;

    @ManyToOne
    @JoinColumn(name = "medidores_id", nullable = false)
    private Medidores medidores;

    public Facturas() {
    }

    public Facturas(Integer numeroFactura, String fechaEmision, Double consumo, Double totalPagar, Medidores medidores) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.consumo = consumo;
        this.totalPagar = totalPagar;
        this.medidores = medidores;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Medidores getMedidores() {
        return medidores;
    }

    public void setMedidores(Medidores medidores) {
        this.medidores = medidores;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
