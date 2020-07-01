<%@page import="com.sikiedu.model.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
*{
font-size: 14px;
}
</style>
</head>
<body>
<h1>商品管理</h1>
<hr/>
<a>添加</a>
<table border="1" >
<tr>
<td>商品名</td><td>描述</td><td>价格</td><td>库存</td><td>操作</td>
</tr>
<c:forEach items="${list }" var="g">
<tr>
<td>${g.name }</td><td>${g.des }</td><td>${g.price }</td><td>${g.inventory }</td><td>删除 修改</td>
</tr>
</c:forEach>
</table>
</body>
</html>