<%@page import="com.sikiedu.util.DBUtil"%>
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
int age = Integer.parseInt(request.getParameter("age"));
String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");

boolean isSuccess = DBUtil.addUser(username, password, age, sex);
if(isSuccess){
	request.setAttribute("message", "注册成功，请登录！");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}else{
	request.setAttribute("message", "注册失败，用户名重复！");
	request.getRequestDispatcher("register.jsp").forward(request, response);
}
%>
<%-- 
if(isSuccess){
// 	out.println("<font color='green'>注册成功</font>");
%>
	<font color='green'>恭喜！用户名：<%=username %>注册成功</font>
<%
}else{
// 	out.println("<font color='red'>注册失败</font>");
%>
	<font color='red'>注册失败</font>
<%
}
%>
--%>
</body>
</html>

