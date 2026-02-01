package com.ash.expensetracker.util;

import java.sql.Connection;

public class DBTest {
	public static void main(String[] args) {
		try (Connection con = DBConnectionUtil.getConnection()) {
			System.out.println("DB Connected Successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
