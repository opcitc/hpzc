<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>导航</title>

<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<script src="../js/bootstrap.min.js"></script>

<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>



<style type="text/css">
body {
	color: #000;
	font-size: 12px;
	font-family: "Helvetica Neue", Helvetica, STheiti, 微软雅黑, 宋体, Arial,
		Tahoma, sans-serif, serif;
}
/*左侧菜单*/
.sidebar-menu {
	border-right: 1px solid #c4c8cb;
}
/*一级菜单*/
.menu-first {
	height: 45px;
	line-height: 45px;
	background-color: #e9e9e9;
	border-top: 1px solid #efefef;
	border-bottom: 1px solid #e1e1e1;
	padding: 0;
	font-size: 14px;
	font-weight: normal;
	text-align: center;
}
/*一级菜单鼠标划过状态*/
.menu-first:hover {
	text-decoration: none;
	background-color: #d6d4d5;
	border-top: 1px solid #b7b7b7;
	border-bottom: 1px solid #acacac;
}
/*二级菜单*/
.menu-second li a {
	background-color: #f6f6f6;
	height: 31px;
	line-height: 31px;
	border-top: 1px solid #efefef;
	border-bottom: 1px solid #efefef;
	font-size: 12px;
	text-align: center;
}
/*二级菜单鼠标划过样式*/
.menu-second li a:hover {
	text-decoration: none;
	background-color: #66c3ec;
	border-top: 1px solid #83ceed;
	border-bottom: 1px solid #83ceed;
	border-right: 3px solid #f8881c;
	border-left: 3px solid #66c3ec;
}
/*二级菜单选中状态*/
.menu-second-selected {
	background-color: #66c3ec;
	height: 31px;
	line-height: 31px;
	border-top: 1px solid #83ceed;
	border-bottom: 1px solid #83ceed;
	border-right: 3px solid #f8881c;
	border-left: 3px solid #66c3ec;
	text-align: center;
}
/*覆盖bootstrap的样式*/
.nav-list, .nav-list li a {
	padding: 0px;
	margin: 0px;
}
</style>

</head>
<body>

	<div class="row-fluid">
		<div class="span12">
			<h1>基于bootstrap的菜单</h1>
			<div class="row-fluid">
				<div class="offset1 span2">
					<!--Sidebar content-->
					<div class="sidebar-menu">
						<a href="#userMeun" class="nav-header menu-first collapsed"
							data-toggle="collapse"><i class="icon-user-md icon-large"></i>
							用户管理</a>
						<ul id="userMeun" class="nav nav-list collapse menu-second">
							<li><a href="#"><i class="icon-user"></i> 增加用户</a></li>
							<li><a href="#"><i class="icon-edit"></i> 修改用户</a></li>
							<li><a href="#"><i class="icon-trash"></i> 删除用户</a></li>
							<li><a href="#"><i class="icon-list"></i> 用户列表</a></li>

						</ul>
						<a href="#articleMenu" class="nav-header menu-first collapsed"
							data-toggle="collapse"><i class="icon-book icon-large"></i>
							文章管理</a>
						<ul id="articleMenu" class="nav nav-list collapse menu-second">
							<li><a href="#"><i class="icon-pencil"></i> 添加文章</a></li>
							<li><a href="#"><i class="icon-list-alt"></i> 文章列表</a></li>
						</ul>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>

</html>