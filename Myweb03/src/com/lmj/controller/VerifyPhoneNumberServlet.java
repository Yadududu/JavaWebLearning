package com.lmj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.service.UserService;

/**
 * Servlet implementation class VerifyPhoneNumberServlet
 */
//@WebServlet("/VerifyPhoneNumber")
public class VerifyPhoneNumberServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneNumber = request.getParameter("phoneNumber");
		UserService userService = new UserService();
		boolean b = userService.isEmpty(phoneNumber);
		response.getWriter().append("{\"isSuccess\":" + b + "}");
	}

}
