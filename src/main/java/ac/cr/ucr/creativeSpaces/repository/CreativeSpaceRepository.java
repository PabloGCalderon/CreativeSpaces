package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Esta clase es una interfaz que se encarga de editar la base de datos directamente
public interface CreativeSpaceRepository extends JpaRepository<CreativeSpace,Integer> {
    Optional<CreativeSpace> findByType(String type);//Un metodo que retorna un optional de tipo creativeSpace que recibe un String type para buscar por tipo
    Optional<CreativeSpace> findByDay(Integer day);//Un metodo que retorna un optional de tipo creativeSpace que recibe un Integer Day para buscar por dia
    Optional<CreativeSpace> findByLocation(String location);//Un metodo que retorna un optional de tipo creativeSpace que recibe un String location para buscar por locacion
}
