package com.hpzc.service.tms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml", "classpath:/spring-service.xml" })
public class TestRedis extends AbstractJUnit4SpringContextTests {

	Map<String, Object> map = new HashMap<String, Object>();

	@Test
	public void testLoadServerInfo() {
		//
		 Jedis jedis = new Jedis("localhost");
		 String ss = jedis.set("kk","dd");
		 System.out.println(ss);
		 Transaction transaction = jedis.multi();
		 transaction.set("key125", "3366");
		 List<Object> list =  transaction.exec();
		 System.out.println(list);
		 
		// Object[] objs = list.toArray();
		// 如果要变成String数组，需要强转类型。
		// String[] strs = (String[]) list.toArray(new String[list.size()]);
		// System.out.println("Server is running: " + jedis.ping());
		System.out.println("12");
	}

}
