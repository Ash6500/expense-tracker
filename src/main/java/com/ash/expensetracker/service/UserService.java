package com.ash.expensetracker.service;

public interface UserService {
	boolean register(String name, String email, String password);

	int login(String email, String password);
}
