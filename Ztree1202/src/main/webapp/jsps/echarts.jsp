<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/echarts/echarts.min.js"></script>

</head>
<body style="height: 100%; margin: 0">
	<script type="text/javascript">
		$(function(){
			$.ajax({
				url:"${pageContext.request.contextPath}/orders/findAll",
				type:"post",
				dataType:"json",
				data:{},
				success:function(data){
					if(data){
						var dom = document.getElementById("container");
						var myChart = echarts.init(dom);
						var app = {};
						option = null;
						option = {
						    xAxis: {
						        type: 'category',
						        data: [data.oname],
						        name:'姓名'
						    },
						    yAxis: {
						        type: 'value',
						        min:'100',
						        max:'25000',
						        name:'工钱'
						    },
						    series: [{
						        data: [data.totalMoney],
						        type: 'line'
						    }]
						};
						;
						if (option && typeof option === "object") {
						    myChart.setOption(option, true);
						}
					}
				}
			})
		})
	</script>
	 <div id="container" style="height: 100%"></div>
</body>
</html>