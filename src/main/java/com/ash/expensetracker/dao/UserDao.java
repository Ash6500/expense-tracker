package com.ash.expensetracker.dao;

import com.ash.expensetracker.model.User;

public interface UserDao {
	boolean register(User user);

	User findByEmail(String email);
}
