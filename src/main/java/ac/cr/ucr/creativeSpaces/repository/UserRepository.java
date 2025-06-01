package ac.cr.ucr.creativeSpaces.repository;

import ac.cr.ucr.creativeSpaces.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
