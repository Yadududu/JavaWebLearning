package com.sikiedu.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.sikiedu.domain.User;
import com.sikiedu.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserService userService = new UserService();
		//传递数据,判断数据库中是否有user
		boolean success = false;
		try {
			success = userService.findUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success)
		{
			//有,存在(index.html)重定向到index.html
			response.sendRedirect(request.getContextPath()+"/index.html");
		}
		else
		{
			request.setAttribute("error", "用户名或者密码错误!!");
			//没有,不存在(login.jsp)转发到login.jsp
			request.getRequestDispatcher("/login.jsp").forward(request, response);;
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
