package com.lmj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lmj.bean.User;
import com.lmj.service.UserService;
import com.lmj.service.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    UserService us;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//封装成user对象
		User u = new User();
		u.setU_username(username);
		u.setU_password(password);
		
		//通过容器获取userService
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//	    us = (UserService) ac.getBean("userService");
		
		//在web项目中我们只需要一个spring的容器
		//application域
		//ServletContext()生命周期 随着web项目启动而创建 随着web项目关闭而销毁
		
		//ServletContextListener 可以通过配置监听器来达到我们的需求,在web项目创建的时候创建spring容器,销毁时候关闭spring容器
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		us = (UserService) wac.getBean("userService");
		
		//调用service方法验证用户
//		UserService us = new UserServicelmpl();
		User loginUser = us.getUserByInfo(u);
		
		//根据用户验证结果进行操作
		if(loginUser == null) {
			//验证失败 转发到login_page.jsp
			request.setAttribute("errorMsg", "用户名或密码错误!");
			request.getRequestDispatcher("/login_page.jsp").forward(request, response);
		}else {
			//验证成功登陆,重定向到index.jsp
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
