<%@page import="com.sikiedu.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${empty user }">
<a href="${pageContext.request.contextPath }/login.jsp">登录</a> <a href="${pageContext.request.contextPath }/register.jsp">注册</a>
</c:when>
<c:otherwise>
当前登录用户：${user.username }
</c:otherwise>
</c:choose>

<br/>
<hr/>
各种商品的展示
</body>
</html>