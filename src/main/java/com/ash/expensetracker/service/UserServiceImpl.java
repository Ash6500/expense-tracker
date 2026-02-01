package com.ash.expensetracker.service;

import org.mindrot.jbcrypt.BCrypt;

import com.ash.expensetracker.dao.UserDao;
import com.ash.expensetracker.dao.UserDaoImpl;
import com.ash.expensetracker.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean register(String name, String email, String password) {
		// TODO Auto-generated method stub
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

		User user = new User(name, email, hashedPassword);

		return userDao.register(user);
	}

	@Override
	public int login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userDao.findByEmail(email);

		if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
			return user.getId(); // success
		}

		return -1; // failure
	}

}
