package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreativeSpaceRegister implements ICreativeSpaceRegister
{
    private ArrayList<CreativeSpace> listSpace;

    public CreativeSpaceRegister() {
        this.listSpace = new ArrayList<>();
    }

    @Override
    public CreativeSpace addSpace(CreativeSpace creativeSpace) {
        this.listSpace.add(creativeSpace);
        return null;
    }

    @Override
    public List<CreativeSpace> getAllSpace() {
        return this.listSpace;
    }

    @Override
    public CreativeSpace getSpaceByID(Integer id) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if(this.listSpace.get(i).getId()==id)
            {
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace getSpaceByType(String type) {
        for (int i = 0; i < this.listSpace.size(); i++) {
            if (this.listSpace.get(i).getType().equalsIgnoreCase(type)) {
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace getSpaceByDay(Integer day) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if(this.listSpace.get(i).getDay()==day)
            {
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace getSpaceByLocation(String location) {
        for (int i = 0; i < this.listSpace.size(); i++) {
            if (this.listSpace.get(i).getLocation().equalsIgnoreCase(location)) {
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if (this.listSpace.get(i).getId() == id)
            {
                this.listSpace.set(i,creativeSpaceEdit);
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace deleteSpace(Integer id) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if(this.listSpace.get(i).getId()==id)
            {
                CreativeSpace c=this.listSpace.get(i);
                this.listSpace.remove(i);
                return c;
            }
        }
        return new CreativeSpace();
    }

    public Boolean existID(Integer id)
    {
        for (int i= 0; i<this.listSpace.size();i++)
        {
            if(this.listSpace.get(i).getId()==id)
            {
                return true;
            }

        }
        return false;
    }

}
