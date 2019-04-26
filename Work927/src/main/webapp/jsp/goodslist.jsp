<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品展示</title>
<style type="text/css">
	table{
		width: 800px;
		height: 400px;
		vertical-align: middle;
		text-align: center;
	}
	td{
	border-style:solid;
	border-width: 1px;
		
	}

</style>
</head>
<body>
	<a href="${pageContext.request.contextPath }/jsp/goodsadd.jsp">添加商品</a>
	<table>
		<tr>
			<td>商品编号</td>
			<td>商品数量</td>
			<td>供应商</td>
			<td>月销量</td>
			<td>商品图片</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${p.query }" var="goo">
		<tr>
			<td>${goo.id }</td>
			<td>${goo.num_goods }</td>
			<td>${goo.client_goods }</td>
			<td>${goo.num_month }</td>
			<td><img alt="xxxx" src="/xue0606/${goo.pic_url }"></td>
			<td>
				<a href="${pageContext.request.contextPath }/goods/findOneGoods?id=${goo.id}">详情</a>
				<a href="${pageContext.request.contextPath }/goods/findOneGoods2?id=${goo.id}">修改</a>
				<a href="${pageContext.request.contextPath }/goods/delGoods?id=${goo.id}">删除</a>
			</td>
		</tr>
	
	</c:forEach>
	</table>
	<c:if test="${p.currentPageNo>1 }">
			<a href="${p.url }?currentPageNo=${p.currentPageNo-1}">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${p.totalPageCount }" var="n">
			<a href="${p.url }?currentPageNo=${n}">${n }</a>
		</c:forEach>
		<c:if test="${p.currentPageNo<p.totalPageCount }">
			<a href="${p.url }?currentPageNo=${p.currentPageNo+1}">下一页</a>
		</c:if>
</body>
</html>