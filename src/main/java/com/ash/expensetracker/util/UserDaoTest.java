package com.ash.expensetracker.util;

import com.ash.expensetracker.dao.UserDaoImpl;
import com.ash.expensetracker.model.User;

public class UserDaoTest {
	public static void main(String[] args) {
		UserDaoImpl dao = new UserDaoImpl();
		User user = new User("Test User", "test@example.com", "$2a$12$hash"); // use any hash

		boolean success = dao.register(user);
		System.out.println("Insert success? " + success);
	}
}
