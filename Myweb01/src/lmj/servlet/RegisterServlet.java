package lmj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmj.util.DBUtil;

//@WebServlet("/register_do")
public class RegisterServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
   
//    public RegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		//new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");

		System.out.println(new String(sex.getBytes("iso-8859-1"),"utf-8"));

		boolean isSuccess = DBUtil.addUser(username, password, age, sex);
		if(isSuccess){
			request.setAttribute("message", "注册成功，请登录！");
			//请求转发
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//重定向
//			response.sendRedirect("login.jsp");
		}else{
			request.setAttribute("message", "注册失败，用户名重复！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
