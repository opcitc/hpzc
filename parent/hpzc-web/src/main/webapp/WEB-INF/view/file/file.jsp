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

	<!-- <form enctype="multipart/form-data" action="upload" />">
		<input type="file" name="file1" /> <input type="text" name="alais" /><br />
		<input type="file" name="file2" /> <input type="text" name="alais" /><br />
		<input type="file" name="file3" /> <input type="text" name="alais" /><br />
		<input type="submit" value="上传" />
	</form> -->

	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> 
		<input type="submit" value="Submit" />
	</form>
	<form action="download" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="download" />
	</form>
	
</body>
</html>
