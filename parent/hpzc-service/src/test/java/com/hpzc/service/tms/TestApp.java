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

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml", "classpath:/spring-service.xml" })
public class TestApp extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcCgdService hpzcCgdService;
	Map<String, Object> map = new HashMap<String, Object>();

	@Test
	public void testLoadServerInfo() {
		List<HpzcCgdDetail> list = hpzcCgdService.selectByQueryDetail("GH-20160820001");
		System.out.println(list.size());

	}

}
