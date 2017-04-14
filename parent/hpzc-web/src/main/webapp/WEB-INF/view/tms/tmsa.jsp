<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


	<!-- <input type="button" onclick="exportExcel()" /> -->
	<form action="${pageContext.request.contextPath}/execl"
		enctype="multipart/form-data" method="post">
			type="submit" value="提交">
	</form>
</body>

<script>
	function exportExcel() {
		location.href = "${pageContext.request.contextPath}/execl";
	}
</script>
</html>