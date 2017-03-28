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
			<form action="">
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
			</form>
			<button id="search">提交</button>
		</div>
	</div>
</body>
<script>
	function cgddata() {
		return {
			hPurName : $('#hPurName').val(),
			hPlayName : $('#hPlayName').val(),
			hGysmc : $('#hGysmc').val(),
			hRemark1 : $('#hRemark1').val(),
			hDate : $('#hDate').val(),
			hPurMoney : $('#hPurMoney').val(),
			hZffsmc : $('#hZffsmc').val(),
			hZfje1 : $('#hZfje1').val(),
			hMemo1 : $('#hMemo1').val()
		}
	}
	
	$('#search').click(function() {
		var paramsMap = cgddata();
		var paramsShow = JSON.stringify(paramsMap);
		$.ajax({
			url : "./hpzcCgdSaveJson",
			data : {
				"hpzcCgd" : paramsShow,
			},
			success : function(data) {
				alert("成功!");
			},
			error : function(data) {
				alert(data.error);
			}
		})

	})

</script>
</html>