<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Basic Menu</h2>
	<p>Right click on page to display menu.</p>
	<div style="margin: 20px 0;"></div>

	<div id="mm" class="easyui-menu" style="width: 120px;">
		<div>
			<span>Open</span>
			<div style="width: 150px;">
				<div>
					<b>Word</b>
				</div>
				<div>Excel</div>
				<div>PowerPoint</div>
				<div>
					<span>M1</span>
					<div style="width: 120px;">
						<div>sub1</div>
						<div>sub2</div>
						<div>
							<span>Sub</span>
							<div style="width: 80px;">
								<div>sub22</div>
								<div>sub23</div>
							</div>
						</div>
						<div>sub3</div>
					</div>
				</div>
			</div>
		</div>
		<div>Exit</div>
	</div>
</body>

<script type="text/javascript">
	$(document).on('contextmenu', function(e) {
		e.preventDefault();
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
	})
</script>

</html>