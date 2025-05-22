package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.User;

import java.util.List;

public interface IRegisterUser
{
    public User addUser(User user);
    public List<User> getAllUser();
    public User getUser (Integer id);
    public User deleteUser(Integer id);
    public User editUser(Integer id, User userEdit);


}
