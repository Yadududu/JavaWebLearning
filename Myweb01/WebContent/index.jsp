<%@page import="java.util.List"%>
<%@page import="lmj.model.User"%>
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
Object o = session.getAttribute("user");
if(o!=null){
	User user = (User)o;
	out.println("当前登录用户："+user.getUsername()+"<br/>");
}
%>
<%
Object o2 = application.getAttribute("userNumber");
if(o2!=null){
	out.println("当前登录用户："+o2+"个!<br/>");
}
%>

<a href="login.jsp">登录</a> <a href="register.jsp">注册</a> 

</body>
</html>