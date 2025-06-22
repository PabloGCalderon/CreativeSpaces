package com.example.practica.controller;

import com.example.practica.model.Facturas;
import com.example.practica.model.Medidores;
import com.example.practica.services.FacturasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController {

    @Autowired
    private FacturasServices facturaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFactura(@PathVariable Integer id) {
        Optional<Facturas> factura = facturaService.obtenerFacturaPorId(id);
        if (!factura.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La factura con el ID " + id + " no fue encontrada");
        }
        return ResponseEntity.ok(factura.get());
    }

    @PostMapping
    public ResponseEntity<?> addFactura(@Validated @RequestBody Facturas factura, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        // Validar que el medidor existe
        Optional<Medidores> medidorOp = facturaService.obtenerMedidorPorId(factura.getMedidores().getNumeroUnico());
        if (!medidorOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El medidor con ID " + factura.getMedidores().getNumeroUnico() + " no existe.");
        }

        Facturas facturaCreada = facturaService.crearFactura(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editFactura(@Validated @PathVariable Integer id,
                                         @RequestBody Facturas facturaEdit,
                                         BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Optional<Facturas> facturaOp = facturaService.obtenerFacturaPorId(id);
        if (facturaOp.isPresent()) {
            if (!id.equals(facturaEdit.getNumeroFactura())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El ID de búsqueda no coincide con el ID del objeto");
            }
            return ResponseEntity.ok(facturaService.actualizarFactura(facturaEdit));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("La factura con el ID " + id + " no se encuentra registrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable Integer id) {
        Optional<Facturas> facturaOp = facturaService.obtenerFacturaPorId(id);
        if (!facturaOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("La factura con el ID " + id + " no fue encontrada");
        }
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }
}
