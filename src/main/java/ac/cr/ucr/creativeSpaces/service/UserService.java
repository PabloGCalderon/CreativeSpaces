package ac.cr.ucr.creativeSpaces.service;


import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.repository.IRegisterUser;
import ac.cr.ucr.creativeSpaces.repository.UserRegister;
import ac.cr.ucr.creativeSpaces.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    //UserRegister userRegister; --> Esto se sustituyo por el private UserRepository


    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public List<User> findAllUser() {
        return userRepository.findAll();
    }


    public Optional<User> findByIDUser(Integer id) {
        return userRepository.findById(id);
    }


    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }

 /*
    public User editUser(Integer id, User userEdit) {

        return this.userRegister.editUser(id,userEdit);
    }

    public Boolean existID(Integer id)
    {
        return this.userRegister.existID(id);
    }\
    */
}
