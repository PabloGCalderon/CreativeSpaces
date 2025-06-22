package com.example.practica.controller;

import com.example.practica.model.Clientes;
import com.example.practica.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClienteServices clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCliente(@PathVariable Integer id) {
        Optional<Clientes> cliente = clienteService.obtenerPorId(id);
        if (!cliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El cliente con el ID " + id + " no fue encontrado");
        }
        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping
    public ResponseEntity<?> addCliente(@Validated @RequestBody Clientes cliente, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        if (clienteService.existeCedula(cliente.getCedula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El cliente con cédula " + cliente.getCedula() + " ya está registrado");
        }

        Clientes clienteAdd = clienteService.crearCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteAdd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCliente(@Validated @PathVariable Integer id,
                                         @RequestBody Clientes clienteEdit,
                                         BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Optional<Clientes> clienteOp = clienteService.obtenerPorId(id);
        if (clienteOp.isPresent()) {
            if (!id.equals(clienteEdit.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El ID de búsqueda no coincide con el ID del objeto");
            }
            return ResponseEntity.ok(clienteService.actualizarCliente(clienteEdit));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("El cliente con el ID " + id + " no se encuentra registrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
        Optional<Clientes> clienteOp = clienteService.obtenerPorId(id);
        if (!clienteOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El cliente con el ID " + id + " no fue encontrado");
        }
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
