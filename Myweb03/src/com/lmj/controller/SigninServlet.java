package com.lmj.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmj.model.Goods;
import com.lmj.model.User;
import com.lmj.service.GoodService;
import com.lmj.service.UserService;
import com.lmj.util.DButil;

/**
 * Servlet implementation class SigninServlet
 */
//@WebServlet("/signin_do")
public class SigninServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u =  userService.login(username, password);
		
		if(!userService.isExist(username)) {
			request.setAttribute("msg", "<font color = 'red'>’À∫≈≤ª¥Ê‘⁄!</font>");
			request.getRequestDispatcher("signin.jsp").forward(request, response);
			return;
		}
		if(u == null) {
			request.setAttribute("msg", "<font color = 'red'>’À∫≈ªÚ’ﬂ√‹¬Î¥ÌŒÛ!</font>");
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}else {
			if(u.isAdmin()) {
				List<Goods> list = new GoodService().selectAllGoods();
				request.getSession().setAttribute("user", u);
				request.setAttribute("list", list);
				request.setAttribute("msg", "<font color = 'green'>"+ u.getUsername() + ",ƒ„∫√!</font>");
//				request.getRequestDispatcher("/Admin/background.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath() +"/Admin/background.jsp");
			}else {
				List<Goods> list = new GoodService().selectAllGoods();
				request.getSession().setAttribute("user", u);
				request.setAttribute("list", list);
				request.setAttribute("msg", "<font color = 'green'>"+ u.getUsername() + ",ƒ„∫√!</font>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
