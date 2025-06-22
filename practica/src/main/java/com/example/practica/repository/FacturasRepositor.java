package com.example.practica.repository;

import com.example.practica.model.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturasRepositor extends JpaRepository<Facturas, Integer> {
    List<Facturas> findByMedidoresNumeroUnico(Integer numeroUnico);
}
