package pl.polsl.service;

import pl.polsl.domain.Subject;
import pl.polsl.domain.User;

public interface AddRates {
	
	public void addRatesPerUser(User user, Subject subject, int rate);

}
