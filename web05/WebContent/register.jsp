<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name='username']").blur(verifyUsername);
});
function verifyUsername(){
// 	$("input[name='username']").val()
	$.ajax({
		url:encodeURI("${pageContext.request.contextPath }/verifyusername"),
		type:"post",
		data:{
			username:$("input[name='username']").val()
		},
		dataType:"json",
		success:function(msg){
// 			$("#msg").append(msg);
			if(msg.isSuccess){
				$("#msg").html("<font color='green'>用户名可以用!</font>");
			}else{
				$("#msg").html("<font color='red'>用户名重复!</font>");
			}
			
		}
	});
}
</script>
</head>
<body>
${msg }<br/>
<form action="${pageContext.request.contextPath }/register_do" method="post">
用户名：<input type="text" name="username" /> <div id="msg"></div> <br/>
密码：<input type="password" name="password" /><br/>
年龄：<input type="text" name="age" /><br/>
性别： 男<input type="radio" name="sex" value="男" checked="checked" />女<input type="radio" name="sex" value="女" /><br/>
<input type="submit" value="注册" />
</form>
</body>
</html>