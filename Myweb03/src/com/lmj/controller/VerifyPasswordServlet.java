package com.lmj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.service.UserService;

/**
 * Servlet implementation class VerifyPasswordServlet
 */
//@WebServlet("/VerifyPassword")
public class VerifyPasswordServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		UserService userService = new UserService();
		boolean b = userService.isCorrectPassword(password);
		response.getWriter().append("{\"isSuccess\":" + b + "}");
	}

}