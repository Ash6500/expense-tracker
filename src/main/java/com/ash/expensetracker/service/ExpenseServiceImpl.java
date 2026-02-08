package com.ash.expensetracker.service;

import java.util.List;

import com.ash.expensetracker.dao.ExpenseDao;
import com.ash.expensetracker.dao.ExpenseDaoImpl;
import com.ash.expensetracker.model.Expense;

public class ExpenseServiceImpl implements ExpenseService {

	private ExpenseDao expenseDao = new ExpenseDaoImpl();

	@Override
	public boolean addExpense(Expense expense) {
		// TODO Auto-generated method stub
		return expenseDao.addExpense(expense);
	}

	@Override
	public List<Expense> getUserExpenses(int userId) {
		// TODO Auto-generated method stub
		return expenseDao.getExpensesByUser(userId);
	}

	@Override
	public boolean deleteExpense(int expenseId, int userId) {
		// TODO Auto-generated method stub
		return expenseDao.deleteExpense(expenseId, userId);
	}

}
