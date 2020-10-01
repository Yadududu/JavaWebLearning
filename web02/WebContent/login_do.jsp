<%@page import="com.sikiedu.util.DBUtil"%>
<%@page import="com.sikiedu.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

User user = DBUtil.verifyAccount(username, password);
if(user==null){
// 	out.println("登录失败,用户名或密码错误！");
	request.setAttribute("message", "<font color='red'>登录失败,用户名或密码错误！</font>");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}else{
	
// 	out.println("登录成功");
	
	int number = 0;
	
	if(application.getAttribute("userNumber")!=null){
		number =(Integer) application.getAttribute("userNumber");
	}
	
	number++;
	
	application.setAttribute("userNumber", number);

	session.setAttribute("user", user);
	request.getRequestDispatcher("personCenter.jsp").forward(request, response);
}
%>
</body>
</html>