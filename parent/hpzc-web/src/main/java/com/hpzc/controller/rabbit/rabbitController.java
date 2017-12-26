package com.hpzc.controller.rabbit;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rabbit")
public class rabbitController {

	@Resource
	private Producer pro;
	@Resource
	private Consumer con;
	@Resource
	private RabbitTemplate rabbitTemplate;

	@RequestMapping("/rabbit")
	public String index() {

		String exchange = "testExchange";//// 交换器
		String routeKey = "testQueue";// 队列
		String message = "helloword-wee";// 调用的方法

		// 参数
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("data", "hello");
		param.put("data1", "hello");
		param.put("data2", "hello");
		RabbitMessage msg = new RabbitMessage(exchange, routeKey, message);
		// 发送消息
		pro.sendMessage(msg);
		con.rmqProducerMessage(msg);
		return "easyui/tabs";
	}

}
