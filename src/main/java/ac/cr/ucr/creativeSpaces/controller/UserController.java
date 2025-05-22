package ac.cr.ucr.creativeSpaces.controller;


import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUser()
    {
        return this.userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id)
    {
        return this.userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return this.userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Integer id)
    {
        return this.userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable Integer id,@RequestBody User userEdit)
    {
        return this.userService.editUser(id,userEdit);
    }

}
