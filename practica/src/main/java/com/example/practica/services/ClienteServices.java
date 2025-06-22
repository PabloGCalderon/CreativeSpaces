package com.example.practica.services;

import com.example.practica.model.Clientes;
import com.example.practica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServices {
    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Clientes> obtenerPorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public boolean existeCedula(String cedula) {
        return clienteRepository.existsByCedula(cedula);
    }

    public Clientes crearCliente(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    public Clientes actualizarCliente(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);

    }
}
