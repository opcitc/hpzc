package com.hpzc.dao.tms;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpzc.common.util.Md5;
import com.hpzc.common.util.SeqNum;
import com.hpzc.dao.shiro.HpzcPermissionMapper;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcXsd;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml" })
public class TestPageHelper extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcPermissionMapper hpzc;
	@Autowired
	private HpzcCgdMapper hpzcCgdDao;
	@Autowired
	private HpzcXsdMapper hpzcXsdDao;

	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

	@Test
	public void test() {
		PageHelper.startPage(2, 8);
		Map<String, Object> map = new HashMap<String, Object>();
		List<HpzcCgd> list = hpzcCgdDao.selectByQuery(map);
		PageInfo<HpzcCgd> p = new PageInfo<HpzcCgd>(list);
		System.out.println(p);
	}

};