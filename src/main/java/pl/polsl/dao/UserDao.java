package pl.polsl.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import pl.polsl.domain.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
	
	List<User> findByUsername(String username);

}
