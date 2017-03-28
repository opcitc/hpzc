package com.hpzc.controller.rabbit;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

//@Component
public class Consumer {

	@Resource
	private RabbitTemplate rabbitTemplate;

	public void rmqProducerMessage(Object object) {

		RabbitMessage rabbitMessage = (RabbitMessage) object;
		System.out.println(rabbitMessage.getExchange());
		System.out.println(rabbitMessage.getRouteKey());
		System.out.println(rabbitMessage.getParams().toString());
		System.out.println(rabbitTemplate.receiveAndConvert(rabbitMessage.getRouteKey()));
		// System.out.println(rabbitTemplate.convertSendAndReceive(rabbitMessage));
		// System.out.println(rabbitTemplate.convertSendAndReceive(rabbitMessage.getRouteKey(),
		// rabbitMessage));

	}

	// public static void main(String[] args) {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("spring-mvc.xml");
	// AmqpTemplate amqpTemplate = context.getBean(RabbitTemplate.class);
	// System.out.println("Received: " + amqpTemplate.receiveAndConvert());
	// }

}
