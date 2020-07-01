package com.sikiedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.service.UserService;

/**
 * Servlet implementation class VerifyUsernameServlet
 */
@WebServlet("/verifyusername")
public class VerifyUsernameServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("VerifyUsernameServlet");
		String username = request.getParameter("username");
		UserService service = new UserService();
		boolean isExist = service.isExist(username);
		response.getWriter().append("{\"isSuccess\":"+!isExist+"}");
	}

}
