package pl.polsl.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.UserDao;
import pl.polsl.domain.User;
import pl.polsl.service.UserVerification;

@Service
public class UserVerificationImpl implements UserVerification{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Boolean verificationUserCreditonals(String login, String password) {

		Optional<User> user = getUserByLogin(login);
		if(user.isPresent()){
			return checkPassword(user.get().getPassword(), password);
		}
		return false;
	}

	@Override
	public Optional<User> getUserByLogin(String login) {
		Optional<User> user = userDao.findByUsername(login);
		return user;
	}

	@Override
	public Boolean checkPassword(String userPassword, String loginFormPassword) {
		
		if(userPassword.equals(loginFormPassword))
		{
			return true;
		}
		return false;
	}

}
