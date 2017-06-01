package com.hpzc.dao.tms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpzc.model.tms.HpzcCgd;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml" })
public class TestPageHelper extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcCgdMapper hpzcCgdDao;

	@Test
	public void test() {
		PageHelper.startPage(2, 8);
		Map<String, Object> map = new HashMap<String, Object>();
		List<HpzcCgd> list = hpzcCgdDao.selectByQuery(map);
		PageInfo<HpzcCgd> p = new PageInfo<HpzcCgd>(list);
		System.out.println(p);
	}

};