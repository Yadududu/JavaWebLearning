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
Object msg = request.getAttribute("message");
if(msg!=null)
	out.println(msg);
%>

登录 
<hr/>
<form action="login_do" method="post">
用户名：<input type="text" name="username" /><br/>
密码：<input type="password" name="password" /><br/>
<input type="submit" value="登录" />
</form>

</body>
</html>