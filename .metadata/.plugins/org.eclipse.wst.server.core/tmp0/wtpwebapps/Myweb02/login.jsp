<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
${msg }<br/>
登录 
<hr/>

<form action="${pageContext.request.contextPath }/login_do" method="post">
用户名：<input type="text" name="username" /><br/>
密码：<input type="password" name="password" /><br/>
<input type="submit" value="登录" />

</body>
</html>