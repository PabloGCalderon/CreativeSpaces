package ac.cr.ucr.creativeSpaces.service;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import ac.cr.ucr.creativeSpaces.repository.CreativeSpaceRegister;
import ac.cr.ucr.creativeSpaces.repository.CreativeSpaceRepository;
import ac.cr.ucr.creativeSpaces.repository.ICreativeSpaceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//Indica que la clase es un servicio
public class CreativeSpaceService
{
    @Autowired//Permite a la clase conectarse al repositorio para comunicarse con la base de datos
    private CreativeSpaceRepository creativeSpaceRepository;


    public CreativeSpace addSpace(CreativeSpace creativeSpace) {
        return this.creativeSpaceRepository.save(creativeSpace);//Guarda un espacio creativo en la base de datos
    }


    public List<CreativeSpace> findAllSpace() {
        return this.creativeSpaceRepository.findAll();//Busca todos los espacios creativos que estan en la base de datos
    }


    public Optional<CreativeSpace> findByIdSpace(Integer id) {
        return creativeSpaceRepository.findById(id);//Busca un espacio creativo por id y lo devuelve en un optional, el optional es una variable que
        // puede o no contener un dato para evitar errores
    }

    public Optional<CreativeSpace> findByType(String type) {
        return creativeSpaceRepository.findByType(type);//Busca un espacio creativo por tipo y lo devuelve en un optional, el optional es una variable que
        // puede o no contener un dato para evitar errores
    }

    public Optional<CreativeSpace> findByDay(Integer day) {
        return creativeSpaceRepository.findByDay(day);// Busca un espacio creativo por dia y lo devuelve en un optional, el optional es una variable que
        // puede o no contener un dato para evitar errores
    }

    public Optional<CreativeSpace> findByLocation(String location) {
        return creativeSpaceRepository.findByLocation(location);// Busca un espacio creativo por locacion y lo devuelve en un optional, el optional es una variable que
        // puede o no contener un dato para evitar errores
    }



    public CreativeSpace putSpace(Integer id, CreativeSpace creativeSpaceEdit) {
        return creativeSpaceRepository.save(creativeSpaceEdit);//Guarda los datos en la base de datos
    }


    public void deleteSpace(Integer id) {
        this.creativeSpaceRepository.deleteById(id);//Borra los datos buscandolos por id
    }

    public Boolean existID(Integer id){
        return creativeSpaceRepository.existsById(id);//Utilizando el metodo existById del JPARepository hacemos que reciba un integer id y asi se asegura que exista
    }

}
