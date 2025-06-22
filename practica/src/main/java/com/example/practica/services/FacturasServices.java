package com.example.practica.services;

import com.example.practica.model.Facturas;
import com.example.practica.model.Medidores;
import com.example.practica.repository.FacturasRepositor;
import com.example.practica.repository.MedidoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServices {

    @Autowired
    private FacturasRepositor facturaRepository;

    @Autowired
    private MedidoresRepository medidorRepository;

    public Optional<Facturas> obtenerFacturaPorId(Integer id) {
        return facturaRepository.findById(id);
    }

    public Optional<Medidores> obtenerMedidorPorId(Integer id) {
        return medidorRepository.findById(id);
    }

    public Facturas crearFactura(Facturas factura) {
        double subtotal = calcularMonto(factura.getConsumo());
        double totalConIva = subtotal * 1.13;

        factura.setFechaEmision(factura.getFechaEmision());
        factura.setTotalPagar(totalConIva);

        return facturaRepository.save(factura);
    }

    public Facturas actualizarFactura(Facturas factura) {
        // Se puede recalcular el total si cambió el consumo
        double subtotal = calcularMonto(factura.getConsumo());
        factura.setTotalPagar(subtotal * 1.13);
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Integer id) {
        facturaRepository.deleteById(id);
    }

    private double calcularMonto(double consumo) {
        if (consumo <= 100) return consumo * 1100;
        else if (consumo <= 200) return consumo * 1450;
        else if (consumo <= 350) return consumo * 1650;
        else return consumo * 1950;
    }
}
