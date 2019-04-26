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
		<SCRIPT type="text/javascript">
		
		var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
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
				beforeDrag: beforeDrag,
				beforeClick: beforeClick
			},
			async: {
				enable: true,
				url: "${pageContext.request.contextPath}/city/findcity", 
				type:"get",
				autoParam: ["id"]
			}
		};		
		function fontCss(treeNode) {
			var aObj = $("#" + treeNode.tId + "_a");
			if (treeNode === curSrcNode) {
				aObj.addClass(curType);			
			}
		}
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeClick(treeId, treeNode) {
			return !treeNode.isCur;
		}
		var curSrcNode, curType;
		function setCurSrcNode(treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			if (curSrcNode) {
				delete curSrcNode.isCur;
				var tmpNode = curSrcNode;
				curSrcNode = null;
				fontCss(tmpNode);
			}
			curSrcNode = treeNode;
			if (!treeNode) return;
			curSrcNode.isCur = true;			
			zTree.cancelSelectedNode();
			fontCss(curSrcNode);
		}		
		function cut(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请先选择一个节点");
				return;
			}
			curType = "cut";
			setCurSrcNode(nodes[0]);
		}
		function paste(e) {
			if (!curSrcNode) {
				alert("请先选择一个节点进行 复制 / 剪切");
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			targetNode = nodes.length>0? nodes[0]:null;
			if (curSrcNode === targetNode) {
				alert("不能移动，源节点 与 目标节点相同");
				return;
			} else if (curType === "cut" && ((!!targetNode && curSrcNode.parentTId === targetNode.tId) || (!targetNode && !curSrcNode.parentTId))) {
				alert("不能移动，源节点 已经存在于 目标节点中");
				return;
			}  else if (curType === "cut") {
				targetNode = zTree.moveNode(targetNode, curSrcNode, "inner");
				if (!targetNode) {
					alert("剪切失败，源节点是目标节点的父节点");
				}
				targetNode = curSrcNode;
			}
			setCurSrcNode();
			delete targetNode.isCur;
			zTree.selectNode(targetNode);
		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
			$("#cut").bind("click", cut);
			$("#paste").bind("click", paste);
		});		
	</SCRIPT>
</head>
<body>

<div class="content_wrap">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="right">
		<ul class="info">
			<li><p>对节点进行 复制 / 剪切，试试看：<br/>
				
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="cut" href="#" title="剪切" onclick="return false;">剪切</a> ]
				&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="paste" href="#" title="粘贴" onclick="return false;">粘贴</a> ]</p>
			</li>
		</ul>
	</div>
</div>
</body>
</html>