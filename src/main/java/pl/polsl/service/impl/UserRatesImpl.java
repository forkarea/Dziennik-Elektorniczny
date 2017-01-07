package pl.polsl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.RatesDao;
import pl.polsl.dao.UserDao;
import pl.polsl.domain.Rates;
import pl.polsl.domain.User;
import pl.polsl.service.UserRates;

@Service
public class UserRatesImpl implements UserRates {
	
	@Autowired
	private RatesDao ratesDao;
	
	@Autowired
	private UserVerificationImpl userVerificationImpl;
	
	@Override
	public List<Rates> getUserRates(String login) {
		
		Optional<List<Rates>> ratesOfUser = null;
		
		Optional<User> user = userVerificationImpl.getUserByLogin(login);
		if(user.isPresent()){
			ratesOfUser = ratesDao.findByUser(user.get());
		}
		
		if(ratesOfUser.isPresent()){
			return ratesOfUser.get();
		}
		
		return InitEmptyList();
	}
	
	private List<Rates> InitEmptyList(){
		List<Rates> emptyList = new ArrayList();
		return emptyList;
	}

}
