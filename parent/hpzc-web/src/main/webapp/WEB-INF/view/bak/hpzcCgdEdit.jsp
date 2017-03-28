<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购单界面</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<div>
		<div id="cgd">
			<!-- <form action="">
				<table>
					<tr>
						<td>采购人:<input id="hPurName" type="text"></td>
						<td>制单人:<input id="hPlayName" type="text"></td>
						<td>供应商名称:<input id="hGysmc" type="text"></td>
					</tr>
					<tr>
						<td>采购描述:<input id="hRemark1" type="text"></td>
						<td>采购日期:<input id="hDate" class="easyui-datebox" type="text"></td>
						<td>采购总金额:<input id="hPurMoney" class="easyui-numberspinner"></td>
					</tr>
					<tr>
						<td>支付方式:<input id="hZffsmc" type="text"></td>
						<td>支付金额:<input id="hZfje1" class="easyui-numberspinner"></td>
						<td>支付描述:<input id="hMemo1" type="text"></td>
					</tr>
				</table>
			</form> -->
			<table id="dg" title="My Users" class="easyui-datagrid"
				style="width: 550px; height: 250px" url="./easyuiJson"
				toolbar="#toolbar" rownumbers="true" fitColumns="true"
				singleSelect="true">
				<thead>
					<tr>
						<th field="hPurName" width="50">username</th>
						<th field="hPlayName" width="50">password</th>
						<th field="hRemark1" width="50">name</th>
						<th field="hGysmc" width="50">tel</th>
						<th field="hZffsmc" width="50">email</th>
					</tr>
				</thead>
			</table>
			<button id="search">提交</button>
		</div>
	</div>
</body>


<script>
	var hpzc = $
	{
		hpzc
	};
</script>
</html>