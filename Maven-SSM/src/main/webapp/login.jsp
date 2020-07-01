<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath }/login" method="get">
		<input type="text" name="username">
		<input type="text" name="password">
		<input type="submit" value="提交">
	</form>
	
	<button onclick="window.location.href='${pageContext.request.contextPath }/list'">游戏列表</button>
	
	<input type=button value="游戏列表" onclick="window.location='list'">
</body>
</html>