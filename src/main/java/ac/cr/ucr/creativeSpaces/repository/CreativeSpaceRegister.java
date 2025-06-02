package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository//Indica que esta clase manipula datos de forma similar a creativeSpaceDAO
public class CreativeSpaceRegister implements ICreativeSpaceRegister
{
    private ArrayList<CreativeSpace> listSpace;//Crea la lista con los espacios

    public CreativeSpaceRegister() {
        this.listSpace = new ArrayList<>();//Inicializa la lista
    }

    @Override
    public CreativeSpace addSpace(CreativeSpace creativeSpace) {
        this.listSpace.add(creativeSpace);//Añade un espacio a la lista
        return null;
    }

    @Override
    public List<CreativeSpace> getAllSpace() {
        return this.listSpace;//Obtiene toda la lista de espacios
    }

    @Override
    public CreativeSpace getSpaceByID(Integer id) {
        for(int i=0;i<this.listSpace.size();i++)//Recorre toda la lista buscando un id en especifico
        {
            if(this.listSpace.get(i).getId()==id)
            {
                return this.listSpace.get(i);//Retorna el espacio de la lista con ese id
            }
        }
        return new CreativeSpace();//Retorna un espacio vacio si no lo encuentra
    }

    @Override
    public CreativeSpace getSpaceByType(String type) {
        for (int i = 0; i < this.listSpace.size(); i++) {
            if (this.listSpace.get(i).getType().equalsIgnoreCase(type)) {//Recorre toda la lista buscando un espacio por tipo mientras ignora las mayusculas o minusculas
                return this.listSpace.get(i);//Retorna el espacio de la lista con ese tipo
            }
        }
        return new CreativeSpace();//Retorna un espacio vacio si no lo encuentra
    }

    @Override
    public CreativeSpace getSpaceByDay(Integer day) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if(this.listSpace.get(i).getDay()==day)//Recorre toda la lista buscando un espacio por dia
            {
                return this.listSpace.get(i);//Retorna el espacio de la lista con ese dia
            }
        }
        return new CreativeSpace();//Retorna un espacio vacio si no lo encuentra
    }

    @Override
    public CreativeSpace getSpaceByLocation(String location) {
        for (int i = 0; i < this.listSpace.size(); i++) {
            if (this.listSpace.get(i).getLocation().equalsIgnoreCase(location)) {//Recorre toda la lista buscando un espacio por locacion
                return this.listSpace.get(i);//Retorna el espacio de la lista con esa locacion
            }
        }
        return new CreativeSpace();//Retorna un espacio vacio si no lo encuentra
    }

    @Override
    public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit) {
        for(int i=0;i<this.listSpace.size();i++)
        {
            if (this.listSpace.get(i).getId() == id)//Recorre toda la lista buscando un objeto por el id que exista
            {
                this.listSpace.set(i,creativeSpaceEdit);//Retorna y asigna las modificaciones al espacio
                return this.listSpace.get(i);
            }
        }
        return new CreativeSpace();
    }

    @Override
    public CreativeSpace deleteSpace(Integer id) {
        for(int i=0;i<this.listSpace.size();i++)//Recorre toda la lista buscando un objeto por el id que exista
        {
            if(this.listSpace.get(i).getId()==id)
            {
                CreativeSpace c=this.listSpace.get(i);
                this.listSpace.remove(i);
                return c;//Borra el espacio y lo retorna
            }
        }
        return new CreativeSpace();//Retiorna un espacio vacio si no lo encuentra
    }

}
