<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>找回密码</title>
	</head>
	<body>
	${msg }<br>
		<table>
			<form action="ForgetPassword_do" method="post">
				<tr><td>用户名:</td><td><input type="text" name="username"></td></tr>
				<tr><td>联系方式:</td><td><input type="text" name="phoneNumber"></td></tr>
				<tr><td><input type="submit" value="确认">
			</form>
			<form action="signin.jsp">
				</td><td><input type="submit" value="返回"></td></tr>
			</form>
		</table>
	</body>
</html>
