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

import com.hpzc.common.util.Md5;
import com.hpzc.common.util.SeqNum;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcXsd;

@ContextConfiguration(locations = { "classpath:/spring-mybatis.xml" })
public class TestCommon extends AbstractJUnit4SpringContextTests {

	@Autowired
	private HpzcUserMapper hpzc;
	@Autowired
	private HpzcCgdMapper hpzcCgdDao;
	@Autowired
	private HpzcXsdMapper hpzcXsdDao;
	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

	@Test
	public void test() {
		
		String s = new String("gunayu");  
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + Md5.string2MD5("zhanghe"));  
        System.out.println("加密的：" + Md5.convertMD5("zhanghe"));  
        System.out.println("解密的：" + Md5.convertMD5(Md5.convertMD5("zhanghe"))); 
		System.out.println(12);
	}
//	594C2F6E7594683B3ADA98506ECA2F0D

}
