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
	<div id="mm" class="easyui-menu" style="width: 120px;">

		<div>新建</div>

		<div>打开</div>

		<div>保存</div>

		<div>退出</div>

	</div>
</body>
<script>
	$('#box').tabs({
		width : 500,
		height : 300,
		plain : true,
		fit : true,
		scrollIncrement : 1,
		scrollDuration : 1000,
		tools : [ {
			iconCls : 'icon-add',
			handler : function() {
				addpan();
			},
		} ],
	});
	function addpan() {
		var content = '<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/hpzcCgd/hpzcCgd" style="width:100%;height:100%;"></iframe>';
		$('#box').tabs('add', {
			title : '新面板',
			selected : true,
			content : content,
		//href:'${pageContext.request.contextPath}/hpzcCgd/hpzcCgd',
		});
	}
</script>
</html>