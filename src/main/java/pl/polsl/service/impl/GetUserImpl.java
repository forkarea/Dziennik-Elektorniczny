package pl.polsl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.polsl.dao.UserDao;
import pl.polsl.domain.User;
import pl.polsl.service.GetUser;

@Service
public class GetUserImpl implements GetUser {
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Iterable<User> usersFromDataBase = userDao.findAll();
		for (User item : usersFromDataBase) {
			users.add(item);
		}
		return users;
	}

	@Override
	public List<User> getUsersList() {
		List<User> users = new ArrayList<User>();
		Iterable<User> usersFromDataBase = userDao.findAll();
		for(User item : usersFromDataBase){
			users.add(item);
		}
		return users;
	}

}
