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
User user = (User)session.getAttribute("user");
%>

用户名：<%=user.getUsername() %><br/>
年龄：<%=user.getAge() %><br/>
性别：<%=user.getSex() %><br/>
</body>
</html>