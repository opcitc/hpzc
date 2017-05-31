<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>

</script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/export/importLoad"
		method="post" enctype="multipart/form-data">
		<input type="file" name="attachment" id="attachment" /> <input
			type="text" name="trueattachment" id="trueattachment" /> <input
			type="submit" value="Submit" />

	</form>
</body>

<script type="text/javascript">
	var attachment = document.getElementById("attachment");
	var trueattachment = document.getElementById("trueattachment");
	attachment.onchange = function() {
		trueattachment.value = getFullPath(this);
	}
	function getFullPath(obj) {
		if (obj) {
			//ie 
			if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
				obj.select();
				return document.selection.createRange().text;
			}
			//firefox 
			else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
				if (obj.files) {
					return obj.files.item(0).getAsDataURL();
				}
				return obj.value;
			}
			return obj.value;
		}
	}
</script>


</html>
