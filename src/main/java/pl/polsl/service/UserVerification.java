package pl.polsl.service;

import java.util.Optional;

import pl.polsl.domain.User;

public interface UserVerification {
	
	public Boolean verificationUserCreditonals(String login, String password);
	
	Optional<User> getUserByLogin(String login);
	
	Boolean checkPassword(String userPassword, String loginFormPassword);

}
