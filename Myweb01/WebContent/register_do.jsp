<%@page import="lmj.util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<%
String username = request.getParameter("username");

String password = request.getParameter("password");
int age = Integer.parseInt(request.getParameter("age"));
String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
//new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");

System.out.println(new String(sex.getBytes("iso-8859-1"),"utf-8"));

boolean isSuccess = DBUtil.addUser(username, password, age, sex);
if(isSuccess){
	request.setAttribute("message", "注册成功，请登录！");
	request.getRequestDispatcher("login.jsp").forward(request, response);
}else{
	request.setAttribute("message", "注册失败，用户名重复！");
	request.getRequestDispatcher("register.jsp").forward(request, response);
}
//--%>

</body>
</html>