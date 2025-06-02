package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;

import java.util.List;

public interface ICreativeSpaceRegister
{
    //Una interfaz con todos los metodos que se trabajan en CreativeSpaceRegister

    public CreativeSpace addSpace(CreativeSpace creativeSpace); //Añade un espacio
    public List<CreativeSpace> getAllSpace();//Busca todos los espacios
    public CreativeSpace getSpaceByID(Integer id);//Busca un espacio por id
    public CreativeSpace getSpaceByType(String type);//Busca los espacios por tipo
    public CreativeSpace getSpaceByDay(Integer day);//Busca los espacios por dia
    public CreativeSpace getSpaceByLocation(String location);//Busca los espacios por locacion
    public CreativeSpace editSpace(Integer id, CreativeSpace creativeSpaceEdit);//Edita un espacio ya existente buscandolo por su id
    public CreativeSpace deleteSpace(Integer id);//Borra un espacio ya existente buscandolo por su id


}
