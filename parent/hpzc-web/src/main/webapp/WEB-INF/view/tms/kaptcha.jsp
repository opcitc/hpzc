<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body>

	<div class="form-group">
		<label>验证码 </label>
		<form action="${pageContext.request.contextPath}/checkCode">
			<input name="j_code" type="text" id="kaptcha" maxlength="4"
				class="form-control" /> <br /> <img
				src="${pageContext.request.contextPath}/getCaptchaImage.htm" id="kaptchaImage"
				style="margin-bottom: -3px" /> <a href="#" id="kaptcha1Image"">看不清?换一张</a>
			<input type="submit" value="验证"> <span>${checkCode }</span>
		</form>
	</div>


</body>


<script type="text/javascript"> 

$(function(){  //生成验证码           
    $('#kaptchaImage').click(function () {    
    $(this).hide().attr('src', '${pageContext.request.contextPath}/getCaptchaImage.htm?' + Math.floor(Math.random()*100) ).fadeIn(); });        
});     
   
window.onbeforeunload = function(){    
    //关闭窗口时自动退出    
    if(event.clientX>360&&event.clientY<0||event.altKey){       
        alert(parent.document.location);    
    }    
};    
               
function changeCode() {  //刷新  
    $('#kaptchaImage').hide().attr('src', '${pageContext.request.contextPath}/getCaptchaImage.htm?' + Math.floor(Math.random()*100) ).fadeIn();    
    event.cancelBubble=true;    
}    
</script>   

</html>