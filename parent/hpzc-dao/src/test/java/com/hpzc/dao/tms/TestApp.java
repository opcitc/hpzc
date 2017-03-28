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

import com.hpzc.common.util.SeqNum;
import com.hpzc.dao.test.HpzcTreeMapper;
import com.hpzc.model.test.HpzcTree;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.model.tms.HpzcXsd;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml" })
public class TestApp extends AbstractJUnit4SpringContextTests {

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
		Map<String, String> map = System.getenv();

		BigDecimal bb = new BigDecimal("1.2");
		System.out.println(bb.add(bb));
		System.out.println(bb.subtract(bb));
		System.out.println(bb.multiply(bb));
		System.out.println(bb.divide(bb));

	}

	/*
	 * @Test public void test() { Map<String, Object> map = new HashMap<String,
	 * Object>(); // 申请金额 挂账金额 List<HpzcCgd> list =
	 * hpzcCgdDao.selectByQuery(map); List<HpzcTree> listtree =
	 * hpzcTree.selectByQuery(map); // map.put("xsr", "业务员1"); //
	 * map.put("xsbegin", new Date()); // map.put("xsend", new Date()); //
	 * List<HpzcXsd> list = hpzcXsdDao.selectByQuery(map);
	 * System.out.println(listtree.size()); System.out.println(list.size()); }
	 */

}
