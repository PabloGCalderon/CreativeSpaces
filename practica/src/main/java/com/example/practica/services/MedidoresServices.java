package com.example.practica.services;

import com.example.practica.model.Clientes;
import com.example.practica.model.Medidores;
import com.example.practica.repository.ClienteRepository;
import com.example.practica.repository.MedidoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedidoresServices
{
    @Autowired
    private MedidoresRepository medidorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Medidores> obtenerPorId(Integer id) {
        return medidorRepository.findById(id);
    }

    public boolean existeNumeroMedidor(Integer numeroUnico) {
        return medidorRepository.existsByNumeroUnico(numeroUnico);
    }

    public Optional<Clientes> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public Medidores agregarMedidor(Integer clienteId, Medidores medidor) {
        Clientes cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        medidor.setClientes(cliente);
        return medidorRepository.save(medidor);
    }

    public Medidores actualizarMedidor(Medidores medidor) {
        return medidorRepository.save(medidor);
    }

    public void eliminarMedidor(Integer id) {
        medidorRepository.deleteById(id);
    }
}
