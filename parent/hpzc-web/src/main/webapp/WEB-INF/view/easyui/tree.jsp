<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EASYUI</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<!-- 	<ul class="easyui-tree">
		<li><span>系统管理</span>
			<ul>
				<li><span>主机信息</span>
					<ul>
						<li>版本信息</li>
						<li>数据库信息</li>
					</ul></li>
				<li>更新信息</li>
				<li>程序信息</li>
			</ul></li>
		<li><span>会员管理</span>
			<ul>
				<li>新增会员</li>
				<li>程序信息</li>
			</ul></li>
	</ul> -->

	<ul id="box">
	</ul>


</body>
<script>
	$('#box').tree({
		url : '${pageContext.request.contextPath}/hpzcTest/hpzcTreeData',
		lines : true,
		checkbox : true,
		dnd : true,
		onlyLeafCheck : true,//去除根节点的复选框
		onClick : function(node) {
			alert(node.url);
		},
		/* onBeforeLoad:function(node,param){
			//alert("node"+node);
			//alert("param"+param);
			console.log(param);
		}, */
	})

	/* $('#box').tree({
		lines:true,
		data : [ {
			"id" : 1,
			"text" : "系统管理",
			"children" : [ {
				"id" : 2,
				"text" : "主机信息",
				"state" : "closed",
				"children" : [ {
					"text" : "版本信息"
				}, {
					"text" : "程序信息"
				} ]
			}, {
				"id" : 3,
				"text" : "更新信息",
				"state" : "open",
			}, {
				"id" : 4,
				"text" : "程序信息",
				"state" : "open",
			} ]
		}, {
			"id" : 5,
			"text" : "会员管理",
			"children" : [ {
				"text" : "新增会员",
				"checked" : true,
			}, {
				"text" : "审核会员"
			} ]
		} ]

	}); */
</script>
</html>