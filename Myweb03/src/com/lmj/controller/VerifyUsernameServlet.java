package com.lmj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.service.UserService;

/**
 * Servlet implementation class VerifyUsernameServlet
 */
//@WebServlet("/VerifyUsername")
public class VerifyUsernameServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("VerifyUsernameServlet");
		String username = request.getParameter("username");
		UserService userService = new UserService();
		boolean b = userService.isExist(username);
		response.getWriter().append("{\"isSuccess\":" + !b + "}");
	}

}
