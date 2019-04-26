<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.exedit.js"></script>
	<script type="text/javascript">
	var setting = {
			view: {
				addHoverDom: addHoverDom,//用于当鼠标移动到节点上时，显示用户自定义控件，显示隐藏状态同 zTree 内部的编辑、删除按钮 请务必与 setting.view.removeHoverDom 同时使用
				removeHoverDom: removeHoverDom,//用于当鼠标移出节点时，隐藏用户自定义控件，显示隐藏状态同 zTree 内部的编辑、删除按钮
				dblClickExpand : false,//双击节点时，是否自动展开父节点的标识 默认值: true
				selectedMulti: false//设置是否允许同时选中多个节点。默认值: true
			},
			edit: {
				enable: true,//设置 zTree 是否处于编辑状态
				editNameSelectAll: true,//节点编辑名称 input 初次显示时,设置 txt 内容是否为全选状态。 [setting.edit.enable = true 时生效]
				removeTitle:"删除",//删除按钮的辅助信息
				renameTitle:"重命名"//重命名按钮的辅助信息
			},
			data: {
				simpleData: {
					enable: true,
					idKey : "id",
					pIdKey : "pid",
					rootPId : 0
				},
				key:{
					name : "name"
				}
			},
			callback: {				
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onClick : zTreeOnClick
			}, 
			 async: {
				enable: true,
				url: "${pageContext.request.contextPath}/city/findcity", 
				type:"get",
				autoParam: ["id"]
			}, 
			
		};
	$(function(){
		$("#addG").bind("click",addRootDep);
	})
	var log, className = "dark";
	var rootNum=0;
	//添加根目录 
	function addRootDep(treeId, treeNode){
		rootNum++;
		$.ajax({
			type : "POST",  
		    async : false,  
		    url : "${pageContext.request.contextPath}/city/addCity",  
		    data :  
		    {  
		    	name : "china" + rootNum,
		    	pid:0
		    },
		    success:function(data){
		    	
		    	if(data){
		    		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		    		var newNode=[{name:"china"+rootNum,pid:0}];
		    		zTree.addNodes(null,newNode);
		    		window.location.reload();
		    	}else{
		    		alert("无法添加");
		    		window.location.reload();
		    	}
		    }
		}); 		
	};
	

	// 添加子部门操作
	var newCount = 0;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='添加' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		//var isAdded=false;
		if (btn) btn.bind("click", function(){
			newCount++;
			$.ajax({
				type : "POST",  
			    async : false,  
			    url : "${pageContext.request.contextPath}/city/addCity",  
			    data :  
			    {  
			    	
			    	name : "pro" + newCount,
			    	pid:treeNode.id
			    },
			    success:function(data){
			    	
			    	if(data){
			    		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
						zTree.addNodes(treeNode, {pid:treeNode.id, name:"pro" + (newCount)});
						alert("添加成功");
						window.location.reload();
			    	}else{
			    		alert("添加失敗，请联系管理员！");
			    		window.location.reload();
			    	}
			    }
			});	
					
		});
	};

	// 删除操作
	function beforeRemove(treeId, treeNode) {
		className = (className === "dark" ? "":"dark");
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		var isDel=confirm("确认删除部门 -- " + treeNode.name + " 吗？");			
		if (isDel) {
				$.ajax({
				type : "POST",  
			    async : false,  
			    url : "${pageContext.request.contextPath}/city/delCity",  
			    data :  
			    {  
			    	id : treeNode.id  
			    },
			    success:function(data){
			    	if(data){
			    		alert("删除成功");
			    		window.location.reload();					
			    	}
			    }
			}); 
			
			
		}
	};



	// 在进行重命名之前，进行一下确认
	function beforeEditName(treeId, treeNode) {
		className = (className === "dark" ? "":"dark");
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		return confirm("确认要重命名部门 -- " + treeNode.name + " 吗？");
	};
	// 重命名操作
	function beforeRename(treeId, treeNode, name, isCancel) {
		className = (className === "dark" ? "":"dark");
		if (name.length == 0) {
			alert("节点名称不能为空.");
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			setTimeout(function(){zTree.editName(treeNode)}, 10);
			return false;
		}else{
			
			$.ajax({
				type : "POST",  
			    async : false,  
			    url : "${pageContext.request.contextPath}/city/updateCity",  
			    data :  
			    {  
			    	id : treeNode.id,
			    	name : name
			    },
			    success:function(data){
			    	if (data) {
			    		alert("修改成功");
			    		window.location.reload();
					} else {
						//alert("修改失敗");
						window.location.reload();
					}
			    }
			}); 			
			
		}
	};
	
	function zTreeOnClick(event, treeId, treeNode) {
	    alert(treeNode.id + ", " + treeNode.name);
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	}; 
	
	/* function selectAll(treeId, treeNode){				
		$.ajax({
			type : "get",  		 
		    url : "${pageContext.request.contextPath}/city/findcity",			   
		    dataType:"json",
		    success:function(data){
		    	$.fn.zTree.init($("#treeDemo"), setting,data);		    	
		    }
		}); 
	} */
		
	$(function(){
		$.fn.zTree.init($("#treeDemo"), setting);	
		//$("#selectAll").bind("click",selectAll);
	})	
		
	
	</script>
</head>
<body>
	
	<div class="content_wrap">
	<div class="zTreeDemoBackground left">
	<!-- <button id="selectAll">点击查询</button> -->
	<button id="addG">添加根节点</button>
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	</div>
</body>
</html>