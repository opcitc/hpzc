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
		<div>
			<shiro:hasPermission name="/hpzc/hpzcUser">
			<div class="logo">后台管理</div>
			</shiro:hasPermission>
		</div>
	 </shiro:hasAnyRoles>
	 
20170414:kaptcha验证码验证配置
         可以调整验证码图片的相关设置,可以采用文件,可以在spring文件中配置,可以java类中页面设置(无必要)
20170417:没有spring-webmvc,easypoi会报错
    easypoi引入注意jar包引用问题
20170522:rabbitmq   
         需启动mq服务器:参考tomcat服务器,访问地址:http://localhost:15672  用户/密码  guest/guest
         配置文件配置项:加载mq模板信息,配置mq代理类,持久化消息队列,交换器队列绑定(重要),生产者,消费者,监听.
         生产者发送消息: rabbitTemplate.convertAndSend(object) 参数不能为空
         消费者接收消息: rabbitTemplate.receiveAndConvert()    参数可以为空
Mq基础知识:
    direct exchange 发送消息是要看routingKey的 (默认方法)
    fanout :广播：
	Topic  :订阅：
	Headers : 使用的比较少
	channel.BasicPublish(exchange, "TaskQueue", properties, bytes);
	channel.BasicPublish("", "TaskQueue", properties, bytes);
	topic exchange 有时候的行为会像其他类型的exchange，比如说：
	当routingKey只是有#号的时候，它的行为和fanout的行为是一样的。
	当routingKey什么的没有，空字符串的时候，它的行为是和direct是一样的。
	
20170522:quartz
         注意配置文件的相关配置数据,持久化信息到数据库(重要并且配置灵活),Scheduler对象是关键
    job相关数据库的表结构和语句可在jar包中查找
         熟悉相关job方法
       
20170522:redis
         需启动redis数据库:可通过可视化工具查看数据库数据(RedisDesktopManager)
         配置模板工厂,增删查改的相关方法,方法已封装,参考hibernate和quartz
    
 