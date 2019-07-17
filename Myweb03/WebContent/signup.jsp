<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>注册</title>
	</head>
	<body>
	${msg }<br>
		<table>
			<form action="signup_do" method="post">
				<tr><td>用户名:</td><td><input type="text" name = "username"><div id="msg"></div></td></tr>
				<tr><td>密码:</td><td><input type="text" name = "password"><div id="msgPassword"></td></tr>
				<tr><td>确认密码:</td><td><input type="text" name = "repassword"><div id="msgRepassword"></div></td></tr>
				<tr><td>性别:</td><td><input type="radio" name = "sex" value = "man" checked />男<input type="radio" name = "sex" value = "woman" />女</td></tr>
				<tr><td>联系方式:</td><td><input type="text" name = "phoneNumber"/><div id="msgPhoneNumber"></td></tr>
				<tr><td><input type="submit" value="确认" /></td><td><input type="reset" value="清空" /></td></tr>
			</form>
		</table>
	</body>
</html>
<script type="text/javascript" src="Js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	// document.getElementsByName("username")[0].addEventListener("blur",verifyUsername);
	// function verifyUsername(){
	// 	var xmlhttp=new XMLHttpRequest();
	// 	xmlhttp.open("GET","test1.txt",true);
	// 	xmlhttp.send();
	// 	xmlhttp.onreadystatechange=function(){
	// 		if (xmlhttp.readyState==4 && xmlhttp.status==200){
	// 			document.getElementById("msg").innerHTML=encodeURI(xmlhttp.responseText);
	// 		}
	// 	}
	// }
	$(function() {
		$("input[name='username']").blur(verifyUsername);
	});
	function verifyUsername(){
		$.ajax({ 
			url: "VerifyUsername", 
			type: "post",
			data:{
				username:$("input[name='username']").val()
			},
			dataType:"json",
			success: function(msg){
				//alert(msg.isSuccess);
				if(msg.isSuccess){
					$("#msg").html("<font color='green'>用户名可以使用!</font>");
				}else{
					$("#msg").html("<font color='red'>用户名重复!</font>");
				}
			}
		});
	}
	$(function() {
		$("input[name='password']").blur(verifyPassword);
	});
	function verifyPassword(){
		$.ajax({ 
			url: "VerifyPassword", 
			type: "post",
			data:{
				password:$("input[name='password']").val()
			},
			dataType:"json",
			success: function(msgPassword){
			//	alert(msg.isSuccess);
				if(!msgPassword.isSuccess){
					$("#msgPassword").html("<font color='red'>密码必须是3-6位数</font>");
				}else{
					$("#msgPassword").html("");
				}
			}
		});
	}
	$(function() {
		$("input[name='repassword']").blur(verifyRepassword);
	});
	function verifyRepassword(){
		$.ajax({ 
			url: "VerifyRepassword", 
			type: "post",
			data:{
				password:$("input[name='password']").val(),
				repassword:$("input[name='repassword']").val()
			},
			dataType:"json",
			success: function(msgRepassword){
			//	alert(msg.isSuccess);
				if(!msgRepassword.isSuccess){
					$("#msgRepassword").html("<font color='red'>确认密码跟密码不一致!</font>");
				}else{
					$("#msgRepassword").html("");
				}
			}
		});
	}
	$(function() {
		$("input[name='phoneNumber']").blur(verifyPhoneNumber);
	});
	function verifyPhoneNumber(){
		$.ajax({ 
			url: "VerifyPhoneNumber", 
			type: "post",
			data:{
				phoneNumber:$("input[name='phoneNumber']").val()
			},
			dataType:"json",
			success: function(msgPhoneNumber){
			//	alert(msg.isSuccess);
				if(msgPhoneNumber.isSuccess){
					$("#msgPhoneNumber").html("<font color='red'>电话号码不能为空!</font>");
				}else{
					$("#msgPhoneNumber").html("");
				}
			}
		});
	}
</script>