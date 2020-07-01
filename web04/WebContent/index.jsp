<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>

request response session application

<%
//域对象 page request session application
pageContext.setAttribute("user", "www.sikiedu.com",PageContext.SESSION_SCOPE);
System.out.println(session.getAttribute("user"));
%>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>