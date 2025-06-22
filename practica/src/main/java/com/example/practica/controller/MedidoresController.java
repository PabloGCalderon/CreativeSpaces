package com.example.practica.controller;

import com.example.practica.model.Clientes;
import com.example.practica.model.Medidores;
import com.example.practica.services.MedidoresServices;
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
@RequestMapping("/api/medidores")
public class MedidoresController {

    @Autowired
    private MedidoresServices medidorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedidor(@PathVariable Integer id) {
        Optional<Medidores> medidor = medidorService.obtenerPorId(id);
        if (!medidor.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El medidor con el ID " + id + " no fue encontrado");
        }
        return ResponseEntity.ok(medidor.get());
    }

    @PostMapping
    public ResponseEntity<?> addMedidor(@Validated @RequestBody Medidores medidor, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        if (medidorService.existeNumeroMedidor(medidor.getNumeroUnico()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El número de medidor ya está registrado");
        }

        Optional<Clientes> clienteOp = medidorService.obtenerClientePorId(medidor.getClientes().getId());
        if (!clienteOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El cliente asociado no existe");
        }

        Medidores medidorAdd = medidorService.agregarMedidor(clienteOp.get().getId(), medidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(medidorAdd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editMedidor(@Validated @PathVariable Integer id,
                                         @RequestBody Medidores medidorEdit,
                                         BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Optional<Medidores> medidorOp = medidorService.obtenerPorId(id);
        if (medidorOp.isPresent()) {
            if (!id.equals(medidorEdit.getNumeroUnico())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El ID de búsqueda no coincide con el ID del objeto");
            }
            return ResponseEntity.ok(medidorService.actualizarMedidor(medidorEdit));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("El medidor con el ID " + id + " no se encuentra registrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedidor(@PathVariable Integer id) {
        Optional<Medidores> medidorOp = medidorService.obtenerPorId(id);
        if (!medidorOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El medidor con el ID " + id + " no fue encontrado");
        }
        medidorService.eliminarMedidor(id);
        return ResponseEntity.noContent().build();
    }

}
