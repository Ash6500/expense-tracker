package com.ash.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ash.expensetracker.model.Expense;
import com.ash.expensetracker.util.DBConnectionUtil;

public class ExpenseDaoImpl implements ExpenseDao {
	private static final String INSERT = "INSERT INTO expenses (user_id, category_id, amount, description, epense_date)"
			+ "VALUES (?,?,?,?,?)";

	private static final String SELECT_BY_USER = "SELECT * FROM expenses WHERE user_id = ? ORDER BY expense_date DESC";

	private static final String DELETE = "DELETE FROM expenses WHERE id = ? AND user_id = ?";

	@Override
	public boolean addExpense(Expense e) {
		// TODO Auto-generated method stub

		try (Connection con = DBConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT)) {
			ps.setInt(1, e.getUserId());
			ps.setInt(2, e.getCategoryId());
			ps.setDouble(3, e.getAmount());
			ps.setString(4, e.getDescription());
			ps.setDate(5, Date.valueOf(e.getExpenseDate()));
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Expense> getExpensesByUser(int userId) {
		// TODO Auto-generated method stub
		List<Expense> list = new ArrayList<>();

		try (Connection con = DBConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_BY_USER)) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Expense e = new Expense();
				e.setId(rs.getInt("id"));
				e.setUserId(userId);
				e.setCategoryId(rs.getInt("category_id"));
				e.setAmount(rs.getDouble("amount"));
				e.setDescription(rs.getString("description"));
				e.setExpenseDate(rs.getDate("expense_date").toLocalDate());
				list.add(e);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean deleteExpense(int expenseId, int userId) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(DELETE)) {
			ps.setInt(1, expenseId);
			ps.setInt(2, userId);

			return ps.executeUpdate() > 0;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		return false;
	}

}
