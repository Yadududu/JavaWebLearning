<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登陆</title>
	</head>
	<body>
	${msg }<br> 
<!--<%
	if(request.getAttribute("msg")!=null)
		out.println(request.getAttribute("msg"));
	%>
	<%=request.getAttribute("msg")%>-->
		<table>
			<form action="signin_do" method="post">
				<tr><td>账号:</td><td><input type="text" name = username></tr>
				<tr><td>密码:</td><td><input type="password" name = password></tr>
				<tr><td><input type="submit" value = "登陆"></td>
			</form>
			<form action="forgetPassword.jsp" method="post">
				<td><input type="submit" value = "忘记密码"></td></tr>
			</form>
		</table>
	</body>
</html>
