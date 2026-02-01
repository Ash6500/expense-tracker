package com.ash.expensetracker.controller;

import java.io.IOException;

import com.ash.expensetracker.service.UserService;
import com.ash.expensetracker.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int userId = userService.login(email, password);

		if (userId > 0) {
			req.getSession().setAttribute("userId", userId);
			resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp?error=true");
		}
	}
}
