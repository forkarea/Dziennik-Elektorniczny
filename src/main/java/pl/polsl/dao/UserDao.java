package pl.polsl.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.polsl.domain.User;

public interface UserDao extends CrudRepository<User, Long>{
	
	Optional<User> findByUsername(String username);

}
