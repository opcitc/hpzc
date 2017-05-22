<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	
</script>
</head>

<body>


	${ss}

	<div>
		<input type="button" onclick="outputData()">导出 </br> </br> </br> <input
			type="button">导入
	</div>


</body>

<script type="text/javascript">
	var exportCondition = {};//导出条件<br>//导出功能
	function outputData() {
		$.ajax({
			type : "POST",
			url : path + "/poi",
			data : exportCondition,
			success : function(fileName) {
				alert("成功:" + fileName);
				/* var downUrl = path + "/main/inputAndOutput/download?fileName="
						+ fileName;
				window.location = downUrl; */
			}
		});
	}
</script>


</html>
