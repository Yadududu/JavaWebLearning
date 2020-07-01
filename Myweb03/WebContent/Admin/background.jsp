<%@page import="com.lmj.model.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>后台</title>
	</head>
	<body>
	
	<c:choose>
		<c:when test="${empty user }">
			<table>
				<tr>
					<td>
						<form action = "signin.jsp" method="get">
							<input type = "submit" value = "登陆">
						</form>
					</td>
					<td>
						<form action = "signup.jsp" method="get">
							<input type = "submit" value = "注册">
						</form>
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table>
				<tr><td>${msg }</td><tr>
			</table>
		</c:otherwise>	
	</c:choose>
	
	<h5>----------商品列表--------<h5>
	<table>
		<tr><td>商品</td><td>描述</td><td>价钱</td><td>库存</td><td>操作</td></tr>
		<c:forEach items = "${list }" var = "g" >
		<tr><td>${g.name }</td><td>${g.des }</td><td>${g.price }</td><td>${g.inventory }</td><td>删除 修改</td></tr>
		</c:forEach>

		
<!--		<%
			List<Goods> goods = (List<Goods>)request.getAttribute("list");
			if(goods!=null){
				for(Goods good : goods){
					%><tr><td><%=good.getName()%></td>
					<td><%=good.getDes()%></td>
					<td><%out.print(good.getPrice());%></td>
					<td><%out.print(good.getInventory());%></td><td>删除 修改</td></tr><%
				}
			}
		%>-->
	</table>
	</body>
</html>
