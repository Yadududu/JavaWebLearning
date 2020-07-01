<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">

setInterval("callAjaxByJs()", 2000);
function callAjaxByjQuery() {
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/ajaxrequest?data=我是客户端发送的数据"),
		type:"get",
		cache:false,
		success:function(msg){
			$("#msg").append(msg);
		}
	});
}
function callAjaxByJs(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET",encodeURI("${pageContext.request.contextPath }/ajaxrequest?data=我是客户端发送的数据&"+Math.random()),true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function(){
		if( xmlhttp.readyState==4 && xmlhttp.status==200 ){
			//得到了服务器端的响应
			$("#msg").append(xmlhttp.responseText);
			
		}
	}
}
</script>

</head>
<body>
<form action="${pageContext.request.contextPath }/login_do" method="post">
用户名：<input type="text" name="username" /><br/>
密码：<input type="password" name="password" /><br/>
<input type="submit" value="登录" />
<div id="msg"></div>
</body>
</html>