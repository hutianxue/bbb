<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/static/common/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/user/findAll/1/3">点击查看用户</a>
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/dept/findAllDept/1/3">点击查看部门</a>
</body>
</html>