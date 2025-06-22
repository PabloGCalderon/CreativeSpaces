package com.example.practica.repository;

import com.example.practica.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Clientes,Integer>
{
    Optional<Clientes> findByCedula(String cedula);
    boolean existsByCedula(String cedula);
}
