package com.lmj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.User;
import com.lmj.service.UserService;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
//@WebServlet("/ForgetPassword_do")
public class ForgetPasswordServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		
		String username = request.getParameter("username");
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		
		User u = userService.FinePassword(username, phoneNumber);
		if(u == null) {
			request.setAttribute("msg", "<font color = 'red'>ÃÓ–¥–≈œ¢”–ŒÛ</font>");
			request.getRequestDispatcher("forgetPassword.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "<font color = 'green'>"+ u.getPassword() +"</font>");
			request.getRequestDispatcher("showPassword.jsp").forward(request, response);
		}
	}

}
