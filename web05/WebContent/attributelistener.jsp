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

// application.setAttribute("number2", 100);
// application.setAttribute("number", 200);
// application.removeAttribute("number");
// session.setAttribute("number", 900);
// session.removeAttribute("number");
// request.setAttribute("number", 800);
// request.removeAttribute("number");
session.setAttribute("number", 10);
User u = new User("siki","123",10,"男",true);
// session.setAttribute("xcvsdfwer", u);
session.removeAttribute("xcvsdfwer");
%>

</body>
</html>