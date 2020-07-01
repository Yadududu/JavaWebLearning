package com.lmj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/signup_do")
public class RegisterServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if(!us.isRepetition(password, repassword)) {
			fail(request,response);
			return;
		}
		String sex = request.getParameter("sex");
		int phoneNumber = 0;
		try {
			phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		}catch(Exception e){
			fail(request,response);
			return;
		}
		
		boolean b = us.register(username, repassword, sex, phoneNumber);
		if(b)success(request,response);
		else fail(request,response);
	}
	private void fail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "<font color='red'>×¢²áÊ§°Ü</font>");
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}
	
	private void success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", "<font color='green'>×¢²á³É¹¦</font>");
		request.getRequestDispatcher("signin.jsp").forward(request, response);
	}

}
