package com.ash.expensetracker.controller;

import java.io.IOException;

import com.ash.expensetracker.service.UserService;
import com.ash.expensetracker.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		boolean success = userService.register(name, email, password);

		if (success) {
			resp.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
		} else {
			resp.sendRedirect(req.getContextPath() + "/jsp/register.jsp?error=true");
		}
	}
}
