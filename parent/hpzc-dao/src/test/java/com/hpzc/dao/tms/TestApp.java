package com.hpzc.dao.tms;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.dao.job.HpzcJobMapper;
import com.hpzc.dao.test.HpzcTreeMapper;
import com.hpzc.model.job.HpzcJob;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml" })
public class TestApp extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcJobMapper hpzcJobDao;
	@Autowired
	private HpzcUserMapper hpzc;
	@Autowired
	private HpzcCgdMapper hpzcCgdDao;
	@Autowired
	private HpzcTreeMapper hpzcTree;
	@Autowired
	private HpzcXsdMapper hpzcXsdDao;
	@Autowired
	private HpzcCgdDetailMapper hpzcDetailDao;
	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

	@Test
	public void test1() {
		HpzcJob job = new HpzcJob();
		job.setJobName("qwewq");
		String ss = JsonHelper.encodeObject2Json("12");
		// job.setJobBy1(JsonHelper.encodeObject2Json(JobAction.class));
		System.out.println(ss);
		// hpzcJobDao.insert(job);

	}

}
