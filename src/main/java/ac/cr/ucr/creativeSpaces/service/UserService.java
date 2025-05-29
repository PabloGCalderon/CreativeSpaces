package ac.cr.ucr.creativeSpaces.service;


import ac.cr.ucr.creativeSpaces.model.User;
import ac.cr.ucr.creativeSpaces.repository.IRegisterUser;
import ac.cr.ucr.creativeSpaces.repository.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IRegisterUser
{

    @Autowired
    UserRegister userRegister;





    @Override
    public User addUser(User user) {
        return this.userRegister.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRegister.getAllUser();
    }

    @Override
    public User getUser(Integer id) {
        return this.userRegister.getUser(id);
    }

    @Override
    public User deleteUser(Integer id) {
        return this.userRegister.deleteUser(id);
    }

    @Override
    public User editUser(Integer id, User userEdit) {
        return this.userRegister.editUser(id,userEdit);
    }

    public Boolean existID(Integer id)
    {
        return this.userRegister.existID(id);
    }
}
