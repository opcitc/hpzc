package com.hpzc.controller.rabbit;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Resource
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(RabbitMessage msg) {
		try {
			System.out.println(rabbitTemplate.getConnectionFactory().getHost());
			System.out.println(rabbitTemplate.getConnectionFactory().getPort());

			// 发送信息
			rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg.getParams().toString());

		} catch (Exception e) {
		}

	}

	// public static void main(String[] args) {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("spring-mvc.xml");
	// AmqpTemplate amqpTemplate = context.getBean(RabbitTemplate.class);
	// amqpTemplate.convertAndSend("test spring sync");
	// }

}
