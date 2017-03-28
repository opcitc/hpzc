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
	<table id="dg" title="My Users" class="easyui-datagrid"
		style="width: 550px; height: 250px" url="./easyuiJson"
		toolbar="#toolbar" rownumbers="true" fitColumns="true"
		singleSelect="true">
		<thead>
			<tr>
				<th field="uId" width="50" style="display: none">uId</th>
				<th field="username" width="50">username</th>
				<th field="password" width="50">password</th>
				<th field="name" width="50">name</th>
				<th field="tel" width="50">tel</th>
				<th field="mail" width="50">email</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="newUser()">新增</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
			href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="destroyUser()">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">UserInformation</div>
		<form id="fm" method="post">
			<input id="uId" name="uId" type="hidden">
			<div class="fitem">
				<label>username:</label> <input id="username" name="username"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>password:</label> <input id="password" name="password"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>name:</label> <input id="name" name="name">
			</div>
			<div class="fitem">
				<label>mail:</label> <input id="mail" name="mail"
					class="easyui-validatebox" validType="email">
			</div>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveUser()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>
</body>

<script>
	var url;
	function newUser() {
		$('#dlg').dialog('open').dialog('setTitle', '新增');
		$('#fm').form('clear');
		url = "./saveUser"
	}

	function editUser() {
		var row = $('#dg').datagrid('getSelected');
		if (row) {
			$("#dlg").dialog('open').dialog('setTitle', '编辑用户');
			$('#fm').form('load', row);
			url = "./updateUser?id=" + row.id + "&uId=" + uid + "&username="
					+ username + "&password=" + password + "&name=" + name
					+ "&mail=" + mail;
		}
	}

	function saveUser() {
		var username = $('#username').val();
		var password = $('#password').val();
		var name = $('#name').val();
		var mail = $('#mail').val();
		//jQuery 保存方法
		alert(url + username + password + name + mail);
		$.post(url, {
			username : username,
			password : password,
			name : name,
			mail : mail
		}, function(data) {
			if (data.error) {
				alert(data.error);
			} else {
				alert("保存成功!");
				$('#dg').datagrid('reload');
			}
		});
	}
</script>



</html>