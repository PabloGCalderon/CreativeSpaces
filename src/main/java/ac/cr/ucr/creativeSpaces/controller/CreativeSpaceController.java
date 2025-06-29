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

@CrossOrigin("*")
@RestController//Indica que la clase es un controlador
@RequestMapping("/api/cs")//Indica una ruta generica para los endpoints
public class CreativeSpaceController
{
    @Autowired//Permite a la clase conectarse con el service para que este se comunique con la base de datos
    CreativeSpaceService creativeSpaceService;


    //Get basico que obtiene todos los espacios y utiliza la ruta generica sin cambios
    @GetMapping
    public List<CreativeSpace> getAllSpace() {
        return this.creativeSpaceService.findAllSpace();
    }

    //Get que obtiene un espacio creativo por id y que recibe un id ademas de cambios en el endpoint para no chocar con otros endpoints del tipo get
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getSpaceByID(@PathVariable Integer id) {
        Optional<CreativeSpace> space = creativeSpaceService.findByIdSpace(id);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el ID " + id + " no fue encontrado");
        }//Sisetma de manejo de errores para asegurarse que si exista el id sin que el programa colapse
        return ResponseEntity.ok(space.get());//Devuelve el espacio que se encontro
    }
    //Get que obtiene un espacio creativo por tipo y que recibe un type ademas de cambios en el endpoint para no chocar con otros endpoints del tipo get
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @GetMapping("/type/{type}")
    public ResponseEntity<?> getSpaceByType(@PathVariable String type) {
        Optional<CreativeSpace> space = creativeSpaceService.findByType(type);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio del tipo: " + type);
        }//Sistema de manejo de errores para asegurarse que si exista el id sin que el programa colapse
        return ResponseEntity.ok(space.get());//Devuelve el espacio que se encontro
    }
    //Get que obtiene un espacio creativo por dia y que recibe un day ademas de cambios en el endpoint para no chocar con otros endpoints del tipo get
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @GetMapping("/day/{day}")
    public ResponseEntity<?> getSpaceByDay(@PathVariable Integer day) {
        Optional<CreativeSpace> space = creativeSpaceService.findByDay(day);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio disponible para el día: " + day);
        }//Sisetma de manejo de errores para asegurarse que si exista el id sin que el programa colapse
        return ResponseEntity.ok(space.get());//Devuelve el espacio que se encontro
    }
    //Get que obtiene un espacio creativo por locacion y que recibe un location ademas de cambios en el endpoint para no chocar con otros endpoints del tipo get
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @GetMapping("/location/{location}")
    public ResponseEntity<?> getSpaceByLocation(@PathVariable String location) {
        Optional<CreativeSpace> space = creativeSpaceService.findByLocation(location);
        if (space.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró ningún espacio en la ubicación: " + location);
        }//Sisetma de manejo de errores para asegurarse que si exista el id sin que el programa colapse
        return ResponseEntity.ok(space.get());//Devuelve el espacio que se encontro
    }

    //El postMapping indica que se esta subiendo totalmente un nuevo espacio creativo
    //El RequestBody indica que esta solicitud necesita de un cuerpo para completarse, en este caso para crear un espacio creativo
    @PostMapping
    public ResponseEntity<?> addSpace(@Validated @RequestBody CreativeSpace creativeSpace, BindingResult result) {

        //Registra los errores que el Validated haya encontrado y que este le envio al BindingResult para registrarlos¿
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {//Recorre los errores y los almacena en field error
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);//Retorna los errores que registro BindingResult y validate
        }

    //Se asegura que no exista el id
    if (this.creativeSpaceService.existID(creativeSpace.getId())) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El espacio con el ID " + creativeSpace.getId() + " ya está registrado.");//Retorna este control de error en caso
        //que exista
    }

        //Añade el espacio creativo y retorna en el responseEntity un codigo con el cuerpo creado correctamente
        CreativeSpace spaceAdded = this.creativeSpaceService.addSpace(creativeSpace);
        return ResponseEntity.status(HttpStatus.CREATED).body(spaceAdded);
    }


    //Indica que es un put o edit y recibe un id, ademas de para tener una estructura se separo con edit a pesar de que no deberia de chocar con otras por ser un endpoint diferente
    //El RequestBody indica que esta solicitud necesita de un cuerpo para completarse, en este caso para editar el viejo espacio con las nuevas caracteristicas
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editSpace(@Validated @PathVariable Integer id, @RequestBody CreativeSpace creativeSpaceEdit, BindingResult result)
    {
        //Registra los errores que el Validated haya encontrado y que este le envio al BindingResult para registrarlos
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {//Recorre los errores y los almacena en field error
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);//Retorna los errores que registro BindingResult y validate
        }

        //Se asegura que el id exista
        if (this.creativeSpaceService.existID(id)) {
            if (!id.equals(creativeSpaceEdit.getId())) {//Se asegura que el id que esta recibiendo el url sea el mismo que el del cuerpo modificado
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El ID de la URL no coincide con el ID del objeto enviado.");//En caso que no lo sea retorna este control
            } else {
                CreativeSpace updated = this.creativeSpaceService.putSpace(id, creativeSpaceEdit);
                return ResponseEntity.ok(updated);//Modifica el espacio y retorna en el responseEntity un codigo con el cuerpo editado correctamente
            }
        }

        //Retorna un control de que no existe el id del espacio a modificar
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El espacio con el ID " + id + " no fue encontrado.");
    }

    //Indica que es un delete y recibe un id, ademas de para tener una estructura se separo con idDelete a pesar de que no deberia de chocar con otras por ser un endpoint diferente
    //El PathVariable le indica al endpoint que va a recibir un parametro que no es fijo, en el mismo pathvariable se indica de que tipo es ese dato que recibe
    @DeleteMapping("/idDelete/{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Integer id) {

    //Se asegura que exista el id
    if (!this.creativeSpaceService.existID(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("El espacio con el ID " + id + " no fue encontrado.");//Devuelve un control en caso que no exista
    }

        //Borra el espacio creativo
        this.creativeSpaceService.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }



}
