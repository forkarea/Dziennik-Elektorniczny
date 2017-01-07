package pl.polsl.service;

import java.util.List;

import pl.polsl.domain.Rates;

public interface UserRates {
	
	public List<Rates> getUserRates (String login);

}
