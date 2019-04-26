<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<p>${msg }</p>
	<form action="${pageContext.request.contextPath }/user/login" method="post">
		账号：<input type="text" name="usercode"><br><br>
		密码：<input type="password" name="password"><br><br>
		<input type="submit" value="登录">
		
	</form>
	
</body>
</html>