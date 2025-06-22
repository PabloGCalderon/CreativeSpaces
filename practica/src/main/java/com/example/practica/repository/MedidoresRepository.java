package com.example.practica.repository;

import com.example.practica.model.Medidores;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedidoresRepository extends JpaRepository<Medidores,Integer> {
    Optional<Medidores> findByNumeroUnico(Integer numeroUnico);
    boolean existsByNumeroUnico(Integer numeroUnico);
    List<Medidores> findByClientesId(Integer id);
}
