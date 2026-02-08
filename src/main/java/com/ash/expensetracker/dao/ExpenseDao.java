package com.ash.expensetracker.dao;

import java.util.List;

import com.ash.expensetracker.model.Expense;

public interface ExpenseDao {
	boolean addExpense(Expense expense);

	List<Expense> getExpensesByUser(int userId);

	boolean deleteExpense(int expenseId, int userId);
}
