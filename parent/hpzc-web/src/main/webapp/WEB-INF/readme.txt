20170328进销存项目加入github并且关联Eclipse!
druid: 监控访问:
     http://127.0.0.1:8090/hpzc-web/druid/

20170330:初步实现权限验证,jsp注解模式:
         设置拦截验证url之后：
	会调用身份验证方法doGetAuthenticationInfo：
	加载验证时会调用权限验证方法doGetAuthorizationInfo
	取数据用户的方法：HpzcUser user = (HpzcUser) principals.getPrimaryPrincipal();
	如：注解形式
    jsp页面引入shiro：
	 <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
	 <shiro:hasAnyRoles name='888888,100002'>
		<div
			<shiro:hasPermission name="/hpzc/hpzcUser">
			<div class="logo">后台管理</div>
			</shiro:hasPermission>
		</div>
	 </shiro:hasAnyRoles>
	 
20170414:kaptcha验证码验证