<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改</title>
</head>
<body>
	<p>${msg }</p>
	<form action="${pageContext.request.contextPath }/goods/goodsUpdate" method="post" enctype="multipart/form-data">
	商品编号：<input type="text" name="id" value="${goo.id }"><br><br>
	商品数量：<input type="text" name="num_goods" value="${goo.num_goods }"><br><br>
	供应商：<input type="text" name="client_goods" value="${goo.client_goods }"><br><br>
	月销量：<input type="text" name="num_month" value="${goo.num_month }"><br><br>
	商品图片：<img alt="xxxx" src="/xue0606/${goo.pic_url }"><br>
			<input type="file" name="picurl"><br><br>
			<input type="hidden" name="createtime" value="${goo.createtime }">
			<input type="submit" value="修改">
			<a href="${pageContext.request.contextPath }/goods/findAllGoods?currentPageNo=1">返回</a>
	</form>
</body>
</html>