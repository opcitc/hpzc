package com.hpzc.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hpzc.common.util.UUID;
import com.hpzc.dao.tms.HpzcUserMapper;
import com.hpzc.model.tms.HpzcUser;

@Controller
@RequestMapping("/easyui")
public class easyController {

	@Autowired
	private HpzcUserMapper hpzcUserDao;

	Map<String, Object> map = new HashMap<String, Object>();
	Gson gson = new Gson();

	@RequestMapping("/sender")
	public String sender(Model mm, String receiver, String pswd, String moTime, String mobile, String msg,
			String destcode, String isems, String emshead) {
		System.out.println("sender");
		System.out.println("sender1");
		System.out.println("sender2");
		return "easyui/test";
	}

	@RequestMapping("/easyui")
	public String easyui(Model mm) {
		return "easyui/test";
	}

	@ResponseBody
	@RequestMapping("/saveUser")
	public void saveUser(@RequestParam String username, @RequestParam String password, @RequestParam String name,
			@RequestParam String mail) {
		HpzcUser hpzcUser = new HpzcUser();
		hpzcUser.setuId(UUID.getUUID());
		hpzcUser.setUsername(username);
		hpzcUser.setPassword(password);
		hpzcUser.setName(name);
		hpzcUser.setMail(mail);
		System.out.println(hpzcUser);
		hpzcUserDao.insert(hpzcUser);
		// return gson.toJson(hpzcUser);
	}

	@ResponseBody
	@RequestMapping("/updateUser")
	public void updateUser(@RequestParam String id, @RequestParam String uId, @RequestParam String username,
			@RequestParam String password, @RequestParam String name, @RequestParam String mail) {
		HpzcUser hpzcUser = new HpzcUser();
		hpzcUser.setuId(uId);
		hpzcUser.setUsername(username);
		hpzcUser.setPassword(password);
		hpzcUser.setName(name);
		hpzcUser.setMail(mail);
		System.out.println(hpzcUser);
		hpzcUserDao.update(hpzcUser);
		// return gson.toJson(hpzcUser);
	}

	@ResponseBody
	@RequestMapping("/easyuiJson")
	public String easyuiJson(Model mm) {
		// List<HpzcUser> list = new ArrayList<HpzcUser>();
		List<HpzcUser> listUser = hpzcUserDao.selectByMap(map);
		System.out.println(listUser);
		return gson.toJson(listUser);

	}

}
