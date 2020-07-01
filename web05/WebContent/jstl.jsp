<%@page import="java.util.ArrayList"%>
<%@page import="com.sikiedu.model.User"%>
<%@page import="java.util.List"%>
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
<%-- <% request.setAttribute("username", "sikiedu"); %> --%>
<%-- <c:set var="username" value="sikiedu" scope="request"></c:set> --%>
<%-- ${username } --%> 
<%-- <c:remove var="username"/> --%>
<%-- <c:out value="${username }"></c:out> --%>


<c:set var="age" value="19" scope="request"></c:set>
<%-- <c:if test="${age>=18 }"> --%>
<!-- <font color="green">你是成年人</font> -->
<%-- </c:if> --%>

<%-- <c:choose> --%>
<%-- <c:when test="${age>=18 }"> --%>
<!-- <font color="green">你是成年人</font> -->
<%-- </c:when> --%>
<%-- <c:otherwise> --%>
<!-- <font color="red">未成年</font> -->
<%-- </c:otherwise> --%>
<%-- </c:choose> --%>
<%
List<User> list = new ArrayList<User>();
list.add(new User("中国","123",90,"男",false));
list.add(new User("中23国","123",90,"男",false));
list.add(new User("中23国","123",90,"男",false));
list.add(new User("中32国","123",90,"男",false));
list.add(new User("中2国","123",90,"男",false));
request.setAttribute("list", list);
%>
<%-- <c:forEach var="i" begin="1" end="10" > --%>
<%-- ${i }<br/> --%>
<%-- </c:forEach> --%>
<c:forEach items="${list }" var="u">
${u.username }:${u.password }:${u.age }<br/>
</c:forEach>
</body>
</html>