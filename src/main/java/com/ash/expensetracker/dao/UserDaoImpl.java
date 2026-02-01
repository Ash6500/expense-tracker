package com.ash.expensetracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ash.expensetracker.model.User;
import com.ash.expensetracker.util.DBConnectionUtil;

public class UserDaoImpl implements UserDao {

	private static final String INSERT_USER = "INSERT INTO users(full_name, email, password_hash) VALUES (?,?,?)";

	private static final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_USER)) {
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPasswordHash());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		try (Connection con = DBConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(FIND_BY_EMAIL)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullName(rs.getString("full_name"));
				user.setEmail(rs.getString("email"));
				user.setPasswordHash(rs.getString("password_hash"));
				return user;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
