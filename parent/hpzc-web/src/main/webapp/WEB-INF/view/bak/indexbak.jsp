<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.hpzc.model.tms.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>

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

	<div
		data-options="region:'north',title:'header',split:true,noheader:true"
		style="height: 60px; background: #666;">
		<div class="logo">后台管理</div>
		<div class="logout">
			您好!|<a href="http://www.baidu.com">退出</a>
		</div>
	</div>
	<div
		data-options="region:'south',title:'footer',
		split:true,noheader:true"
		style="height: 35px; line-height: 30px; text-align: center;">
		@2011-2016进销存系统</div>
	<div data-options="region:'west',split:true,iconCls:'icon-world'"
		style="width: 180px; padding: 10px;">
		<ul id="nav"></ul>
	</div>
	<div data-options="region:'center',split:true,iconCls:'icon-world'">
		<div id="tabs">
			<div title="起始页" iconCls="icon-house"
				style="padding: 0 10px; display: block;"></div>
			<p>欢迎来到后台管理系统!</p>
		</div>
	</div>
	</div>

</body>
<script>
	$('#tabs').tabs({
		fit : true,
		border : false,
	});
</script>
</html>