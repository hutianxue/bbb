<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/static/common/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#dept").click(function(){
				location.href="${pageContext.request.contextPath}/jsps/avgmoney.jsp";
			})
		})	
		$(function(){
			$("#countt").change(function(){
				var ccount=$("#countt option:selected").val();
				if(ccount){
					location.href="${pageContext.request.contextPath }/dept/findAllDept/1/"+ccount;		
				}
			})
		})
	</script>
</head>
<body>
	<button class="btn btn-primary" id="dept">统计图</button>
	<table class="table table-hover">
    <thead>
        <tr>
            <th>部门名称</th>
            <th>部门编号</th>
            <th>部门平均薪资</th>
                               
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${p.list}" var="d">
    		<tr class="active">
            <td>${d.deptName }</td>
            <td>${d.deptCode }</td>
            <td>${d.avgMoney }</td>
            
                       
        </tr>
    	</c:forEach>        
    </tbody>
</table> 
  <ul class="pagination" style="display: inline">	    
    <li>
    	<c:if test="${p.hasPreviousPage }">
			<a href="${pageContext.request.contextPath }/dept/findAllDept/${p.pageNum-1 }/${ccount}">&laquo;</a>
		</c:if>
    </li>
    <li>
    	<c:forEach begin="1" end="${p.pages }" var="n">
			<a href="${pageContext.request.contextPath }/dept/findAllDept/${n}/${ccount}">${n }</a>
		</c:forEach>
    </li>   
    <li>
    	<c:if test="${p.hasNextPage }">
			<a href="${pageContext.request.contextPath }/dept/findAllDept/${p.pageNum+1 }/${ccount}">&raquo;</a>	
		</c:if>	
    </li>
	</ul>
  <div class="form-group"  style="margin-left:100px;float:left;">
    <!-- <label for="name">选择页码</label> -->
    <select class="form-control" style="display: inline" id="countt">
      <option value="">--可视数--</option>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    </select>
    </div>
	
</body>
</html>