package pl.polsl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.RatesDao;
import pl.polsl.domain.Rates;
import pl.polsl.domain.Subject;
import pl.polsl.domain.User;
import pl.polsl.service.AddRates;

@Service
public class AddRatesImpl implements AddRates {
	
	@Autowired
	RatesDao ratesDao;
	
	@Override
	public void addRatesPerUser(User user, Subject subject, int rate) {
		
		Rates ratePerUser = new Rates(rate, user, subject);
		ratesDao.save(ratePerUser);
		
	}

}
