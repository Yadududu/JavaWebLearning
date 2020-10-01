package com.sikiedu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo_do")//注解 注释
public class DemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		resp.getWriter().append("<html>");
		resp.getWriter().append("<head>");
		resp.getWriter().append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		
		resp.getWriter().append("</head>");
		resp.getWriter().append("<body>");
		resp.getWriter().append("你好 get");
		resp.getWriter().append("</body>");
		resp.getWriter().append("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("我是dopost方法");
	}
}
