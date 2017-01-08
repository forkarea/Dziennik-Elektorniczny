package pl.polsl.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.UserDao;
import pl.polsl.domain.Role;
import pl.polsl.domain.User;
import pl.polsl.service.UserVerification;

@Service
public class UserVerificationImpl implements UserVerification{
	
	private final static String ADMIN_ROLE = "admin";
	private final static String USER_ROLE = "user";

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

	@Override
	public String getRolePerLogin(String login) {
		Optional<User> user = getUserByLogin(login);
		String role = null;
		if(user.isPresent()){
			Set<Role> rolesOfUser = user.get().getRole();
			Optional<Role> roleOfUser = rolesOfUser.stream().filter(item -> item.getRoleName().equals(ADMIN_ROLE)).findAny();
			if (roleOfUser.isPresent()){
				return ADMIN_ROLE;
			}
		}
		return USER_ROLE;
	}
	
	

}
