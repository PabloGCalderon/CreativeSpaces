package ac.cr.ucr.creativeSpaces.controller;


import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/api/users")
public class UserController
{

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUser()
    {
        return this.userService.findAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id)
    {
        Optional<User> user =  this.userService.findByIDUser(id);
        if(user==null || user.get().getId()==0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id " + id + " No fue encontrado");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody User user, BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String, String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        /*if(this.userService.existID(user.getId()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id "+ user.getId()+" ya se encuentra registrado");
        }*/

        User userAdd=this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAdd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id)
    {
        /*if(this.userService.existID(id))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El id "+ id+ " no se ha encontrado");
        }*/
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    /*@PutMapping("/{id}")
    public ResponseEntity<?> editUser(@Validated @PathVariable Integer id,@RequestBody User userEdit, BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String, String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        if(this.userService.existID(id))
        {
            if(id!=userEdit.getId())
            {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("EL id de busqueda no es igual al ID del objeto");
            }
            else
            {
                return ResponseEntity.ok(this.userService.editUser(id, userEdit));
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID "+id+" no se encuentra registrado");
    }*/

}
