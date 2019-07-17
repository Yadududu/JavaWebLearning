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
		//���ձ�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//��װ��user����
		User u = new User();
		u.setU_username(username);
		u.setU_password(password);
		
		//ͨ��������ȡuserService
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//	    us = (UserService) ac.getBean("userService");
		
		//��web��Ŀ������ֻ��Ҫһ��spring������
		//application��
		//ServletContext()�������� ����web��Ŀ���������� ����web��Ŀ�رն�����
		
		//ServletContextListener ����ͨ�����ü��������ﵽ���ǵ�����,��web��Ŀ������ʱ�򴴽�spring����,����ʱ��ر�spring����
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		us = (UserService) wac.getBean("userService");
		
		//����service������֤�û�
//		UserService us = new UserServicelmpl();
		User loginUser = us.getUserByInfo(u);
		
		//�����û���֤������в���
		if(loginUser == null) {
			//��֤ʧ�� ת����login_page.jsp
			request.setAttribute("errorMsg", "�û������������!");
			request.getRequestDispatcher("/login_page.jsp").forward(request, response);
		}else {
			//��֤�ɹ���½,�ض���index.jsp
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}