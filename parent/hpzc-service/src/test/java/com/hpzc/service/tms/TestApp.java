package com.hpzc.service.tms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.dao.job.HpzcJobMapper;
import com.hpzc.model.job.HpzcJob;
import com.hpzc.model.job.JobAction;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml", "classpath:/spring-service.xml" })
public class TestApp extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcCgdService hpzcCgdService;
	Map<String, Object> map = new HashMap<String, Object>();

	
	@Autowired
	private HpzcJobMapper hpzcJobDao;
	
	
	@Test
	public void testLoadServerInfo() {

		

	}

}
