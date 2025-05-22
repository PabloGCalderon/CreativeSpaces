package ac.cr.ucr.creativeSpaces.repository;


import ac.cr.ucr.creativeSpaces.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRegister  implements IRegisterUser
{
    private ArrayList<User> listUser;

    public UserRegister()
    {
        this.listUser=new ArrayList<>();
    }

    @Override
    public User addUser(User user) {
        this.listUser.add(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return this.listUser;
    }

    @Override
    public User getUser(Integer id) {
        for(int i=0;i<this.listUser.size();i++)
        {
            if(this.listUser.get(i).getId()==id)
            {
                return this.listUser.get(i);
            }
        }
        return new User();
    }

    @Override
    public User deleteUser(Integer id) {
        for(int i=0;i<this.listUser.size();i++)
        {
            if(this.listUser.get(i).getId()==id)
            {
                User u=this.listUser.get(i);
                this.listUser.remove(i);
                return u;
            }
        }
        return new User();
    }

    @Override
    public User editUser(Integer id, User userEdit) {
        for(int i=0;i<this.listUser.size();i++)
        {
            if (this.listUser.get(i).getId() == id)
            {
                this.listUser.set(i,userEdit);
                return this.listUser.get(i);
            }
        }
        return new User();
    }
}
