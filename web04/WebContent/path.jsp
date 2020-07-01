<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% System.out.println(request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css" />

<!-- 相对路径css/style.css -->
<!-- 绝对路径/web04/css/style.css  <%=request.getContextPath() %>/css/style.css -->
</head>
<body>

<h1>path.jsp </h1>
<a href="<%=request.getContextPath() %>/test1.jsp">进入test1</a><br/>


<jsp:include page="/product/test2.jsp"></jsp:include>
<%
// 相对路径footer.jsp

// 客户端绝对路径	http://localhost:8080/
// 服务器端绝对路径 http://localhost:8080/web04/
%>
</body>
</html>