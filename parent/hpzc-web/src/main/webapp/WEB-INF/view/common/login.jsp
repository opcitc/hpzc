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
<style type="text/css">
#login {
	padding: 6px 0 0 0;
}

p {
	height: 22px;
	line-height: 22px;
	padding: 4px 0 0 25px;
}

.textbox {
	height: 22px;
	padding: 0 2px;
}

.easyui-linkbutton {
	padding: 0 10px;
}

#btn {
	text-align: center;
}
</style>

</head>

<body>
	<div id="login">
		<p>
			账号:<input type="text" id="manager" class="textbox">
		</p>
		<p>
			密码:<input type="password" id="password" class="textbox">
		</p>
		<p>
			验证码:<input  type="text" id="kaptcha" maxlength="4"
				class="form-control" /> <br /> <img
				src="${pageContext.request.contextPath}/getCaptchaImage" id="kaptchaImage"
				style="margin-bottom: -3px" /><a href="#" onclick="changeCode()">看不清?换一张</a>
		</p>
	</div>
	<div id="btn">
		<a href="#" class="easyui-linkbutton">登录</a>
	</div>
</body>

<script type="text/javascript"> 

$(function(){  //生成验证码           
    $('#kaptchaImage').click(function () {    
    $(this).hide().attr('src', '${pageContext.request.contextPath}/getCaptchaImage?' + Math.floor(Math.random()*100) ).fadeIn(); });        
});     
   
window.onbeforeunload = function(){    
    //关闭窗口时自动退出    
    if(event.clientX>360&&event.clientY<0||event.altKey){       
        alert(parent.document.location);    
    }    
};    
               
function changeCode() {  //刷新  
    $('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/getCaptchaImage?' + Math.floor(Math.random()*100) ).fadeIn();    
   /*  event.cancelBubble=true;    */ 
}    
</script>  


<script>
	//弹出对话框进行登录
	$('#login').dialog({
		title : "欢迎登录",
		width : 300,
		height : 350,
		modal : true,
		iconCls : 'icon-login',
		buttons : '#btn',
	})
	//账号验证
	$('#manager').validatebox({
		required : true,
		missingMessage : '请输入用户名',
		invalidMessage : '用户名不能为空',
	})
	//密码验证
	$('#password').validatebox({
		required : true,
		vaildType : 'length[6,32]',
		missingMessage : '请输入密码',
		invalidMessage : '密码不能为空',
	})

	//加载页面时判断
	if (!$('#manager').validatebox('isValid')) {
		$('#manager').focus();
	} else if (!$('#password').validatebox('isValid')) {
		$('#password').focus();
	}

	//登录按钮
	$('#btn')
			.click(
					function() {
						if (!$('#manager').validatebox('isValid')) {
							$('#manager').focus();
						} else if (!$('#password').validatebox('isValid')) {
							$('#password').focus();
						} else {
							$.ajax({
										url : "${pageContext.request.contextPath}/hpzc/indexinfo",
										type : 'POST',
										data : {
											manager : $('#manager').val(),
											password : $('#password').val(),
											kaptcha : $('#kaptcha').val(),
										},
										beforeSend : function() {
											$.messager.progress({
												text : '正在尝试登录...',
											})

										},
										success : function(date, response,
												status) {
											$.messager.progress('close');
											if (date == '1') {
												/* $.messager.alert('登录成功!',
														'登录成功!'); */
												window.location.href = "${pageContext.request.contextPath}/hpzc/index";
											} else {
												$.messager.alert('登录失败',
														'用户名或密码错误!', 'waring',
														function() {
															$('password')
																	.select();
														})
											}
										}
									})
						}
					})
</script>
</html>