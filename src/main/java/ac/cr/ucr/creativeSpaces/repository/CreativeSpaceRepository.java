package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.CreativeSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreativeSpaceRepository extends JpaRepository<CreativeSpace,Integer> {
    Optional<CreativeSpace> findByType(String type);
    Optional<CreativeSpace> findByDay(Integer day);
    Optional<CreativeSpace> findByLocation(String location);
}
