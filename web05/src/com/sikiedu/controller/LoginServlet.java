package com.sikiedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sikiedu.model.User;
import com.sikiedu.service.UserService;

@WebServlet("/login_do")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserService serive = new UserService();
		User user = serive.login(username, password);
		if(user!=null) {
			req.getSession().setAttribute("user", user);
			
			if(user.isAdmin()) {
//				resp.sendRedirect( "/admin/goods_list.jsp");
//				req.getRequestDispatcher("/admin/goods_list").forward(req, resp);
				resp.sendRedirect(req.getContextPath() +"/admin/goods_list");
			}else {
				req.getRequestDispatcher("/").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
