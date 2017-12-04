<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hpzc.model.tms.*"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script> -->
<t:link />


<style type="text/css">
.logo {
	width: 180px;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	float: left;
	color: #fff;
}

.logout {
	float: right;
	padding: 30px 15px 0 0;
	color: #fff;
}

a {
	color: #fff;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>

<%-- <%
		HpzcUser user = (HpzcUser) session.getAttribute("user");
	%>
	<p><%=user.getUsername()%></p> --%>

</head>

<body class="easyui-layout">
    <shiro:hasAnyRoles name='888888,100002'>
	<div
		data-options="region:'north',title:'header',split:true,noheader:true"
		style="height: 60px; background: #666;">
		<shiro:hasPermission name="/hpzc/hpzcUser">
		<div class="logo">后台管理</div>
		</shiro:hasPermission>
		<div class="logout">
			您好!|<a href="http://localhost:8090/hpzc-web/hpzc/login">退出</a>
		</div>
	</div>
	</shiro:hasAnyRoles>
	<div
		data-options="region:'south',title:'footer',
		split:true,noheader:true"
		style="height: 35px; line-height: 30px; text-align: center;">
		@2011-2016进销存系统</div>
	<div
		data-options="region:'west',split:true,iconCls:'icon-world',title:'导航'"
		style="width: 180px; padding: 10px;">
		<ul id="nav"></ul>
	</div>

	<div id="main"
		data-options="region:'center',split:true,iconCls:'icon-world'">
		<p>欢迎来到后台管理系统!</p>
		<div id="tabs">
			<div title="起始页" iconCls="icon-house" id=""
				style="padding: 0 10px; display: block;"></div>
		</div>
	</div>
	</div>

</body>
<script>

	$('#nav').tree({
		url : '${pageContext.request.contextPath}/hpzcUser/nav',
		lines : true,
		onClick : function(node) {
			if (node.url) {
				if ($('#tabs').tabs('exists', node.text)) {
					$('#tabs').tabs('select', node.text)
				} else {
					var url = node.url;
					console.log(url);
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
					console.log(content);
					//var content = '<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/hpzcCgd/hpzcCgd" style="width:100%;height:100%;"></iframe>';
					$('#tabs').tabs('add', {
						title : node.text,
						closable : true,
						content : content,
						//href : node.url,
					});
				}
			}
		}
	});

	$('#tabs').tabs({
		fit : true,
		border : false,
	});
</script>
</html>