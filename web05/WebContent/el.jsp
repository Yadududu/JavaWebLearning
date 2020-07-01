<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<!-- page request session application -->
<% 
// request.setAttribute("number", 2000);
// session.setAttribute("number", "www.sikiedu.com");
// session.setAttribute("user", "www.sikiedu.com");
// session.removeAttribute("user");
// application.setAttribute("count", "sdfsdfsdZ史蒂芬");
%>
<%-- 在线人数为：${requestScope.number } --%>
<!-- <br/> -->
<%-- ${sessionScope.user } --%>
<!-- <br/> -->
<%-- ${applicationScope.count } --%>
<!-- <br/> -->
<%-- ${number2 } --%>

<%
// User u = new User("中国","123",90,"男",false);
// request.setAttribute("user", u);

// Map<String,String> map = new HashMap<String,String>();
// map.put("name", "李四");
// map.put("age", "12");
// request.setAttribute("map", map);

List<User> list = new ArrayList<User>();
list.add(new User("中国","123",90,"男",false));
list.add(new User("中23国","123",90,"男",false));
list.add(new User("中23国","123",90,"男",false));
list.add(new User("中32国","123",90,"男",false));
list.add(new User("中2国","123",90,"男",false));
request.setAttribute("list", list);
%>
<%-- ${user.username } --%>
<%-- ${user.password } --%>
<%-- ${map.name } --%>
<%-- ${map.age } --%>
${list[2].username }
${list[4].username }

${90+90 }
${90>80 }
${empty  list}
${empty  list2}


</body>
</html>