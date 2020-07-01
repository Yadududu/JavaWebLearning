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
 * Servlet implementation class LoginServervlet
 */
@WebServlet("/login_do")
public class LoginServervlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService serive = new UserService();
		User user = serive.login(username, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			if(user.isAdmin()) {
				response.sendRedirect(request.getContextPath() + "/admin/goods_list");
			}else {
				request.getRequestDispatcher("/").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
