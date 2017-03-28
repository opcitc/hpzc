package com.hpzc.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hpzc.redis.dao.Member;
import com.hpzc.redis.dao.MemberDao;

@Controller
@RequestMapping("/redis")
public class redisController {

	@Autowired
	private MemberDao memberDao;
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	// 测试redis
	@RequestMapping("/redis")
	public String redis() {
		// redisTemplate.multi();
		// redisTemplate.exec();
		Member member = new Member();
		member.setId("mdg");
		member.setName("df");
		member = memberDao.get("gh");
		// memberDao.add(member);
		System.out.println(member);
		return "easyui/tabs";
	}

}
