package pl.polsl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.polsl.domain.Rates;
import pl.polsl.domain.User;

public interface RatesDao extends CrudRepository<Rates, Long>{
	
	Optional<List<Rates>> findByUser(User user);

}
