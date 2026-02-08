package com.ash.expensetracker.service;

import java.util.List;

import com.ash.expensetracker.model.Expense;

public interface ExpenseService {
	boolean addExpense(Expense expense);

	List<Expense> getUserExpenses(int userId);

	boolean deleteExpense(int expenseId, int userId);
}
