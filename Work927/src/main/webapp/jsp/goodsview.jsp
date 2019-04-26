<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>详情</title>
</head>
<body>
 	<span>商品编号：${goo.id }</span><br><br>
 	<span>商品数量：${goo.num_goods }</span><br><br>
 	<span>供应商：${goo.client_goods }</span><br><br>
 	<span>月销量：${goo.num_month }</span><br><br>
 	<span>商品图片：<img alt="xxxx" src="/xue0606/${goo.pic_url }"></span><br><br>
 	<a href="${pageContext.request.contextPath }/goods/findAllGoods?currentPageNo=1">返回</a>
</body>
</html>