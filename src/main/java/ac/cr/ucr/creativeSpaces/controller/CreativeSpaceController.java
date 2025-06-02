package ac.cr.ucr.creativeSpaces.controller;


import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.service.CreativeSpaceService;
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
@RequestMapping("/api/cs")
public class CreativeSpaceController
{
    @Autowired
    CreativeSpaceService creativeSpaceService;



    @GetMapping
    public List<CreativeSpace> getAllSpace() {
        return this.creativeSpaceService.findAllSpace();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getSpaceByID(@PathVariable Integer id) {
        Optional<CreativeSpace> space = creativeSpaceService.findByIdSpace(id);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el ID " + id + " no fue encontrado");
        }
        return ResponseEntity.ok(space.get());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> getSpaceByType(@PathVariable String type) {
        Optional<CreativeSpace> space = creativeSpaceService.findByType(type);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio del tipo: " + type);
        }
        return ResponseEntity.ok(space.get());
    }

    @GetMapping("/day/{day}")
    public ResponseEntity<?> getSpaceByDay(@PathVariable Integer day) {
        Optional<CreativeSpace> space = creativeSpaceService.findByDay(day);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio disponible para el día: " + day);
        }
        return ResponseEntity.ok(space.get());
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<?> getSpaceByLocation(@PathVariable String location) {
        Optional<CreativeSpace> space = creativeSpaceService.findByLocation(location);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio en la ubicación: " + location);
        }
        return ResponseEntity.ok(space.get());
    }

    @PostMapping
    public ResponseEntity<?> addSpace(@Validated @RequestBody CreativeSpace creativeSpace, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

    /*
    if (this.creativeSpaceService.existID(creativeSpace.getId())) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El espacio con el ID " + creativeSpace.getId() + " ya está registrado.");
    }
    */

        CreativeSpace spaceAdded = this.creativeSpaceService.addSpace(creativeSpace);
        return ResponseEntity.status(HttpStatus.CREATED).body(spaceAdded);
    }

   /*@PutMapping("/{id}")
    public ResponseEntity<?> editSpace(@Validated @PathVariable Integer id, @RequestBody CreativeSpace creativeSpaceEdit, BindingResult result)
    {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        if (this.creativeSpaceService.existID(id)) {
            if (!id.equals(creativeSpaceEdit.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El ID de la URL no coincide con el ID del objeto enviado.");
            } else {
                CreativeSpace updated = this.creativeSpaceService.editSpace(id, creativeSpaceEdit);
                return ResponseEntity.ok(updated);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el ID " + id + " no fue encontrado.");
    }*/

    @DeleteMapping("/idDelete/{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Integer id) {
    /*
    if (!this.creativeSpaceService.existID(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("El espacio con el ID " + id + " no fue encontrado.");
    }
    */

        this.creativeSpaceService.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }


}
