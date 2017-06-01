package com.hpzc.controller.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.hpzc.common.json.JsonHelper;
import com.hpzc.common.util.UUID;
import com.hpzc.dao.page.PageParam;
import com.hpzc.dao.tms.HpzcUserMapper;
import com.hpzc.model.common.Result;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcUser;
import com.hpzc.service.tms.HpzcCgdService;

@Controller
@RequestMapping("/easyui")
public class easyController {

	@Autowired
	private HpzcUserMapper hpzcUserDao;
	@Autowired
	private HpzcCgdService hpzcCgdService;

	Gson gson = new Gson();

	// 分页
	@RequestMapping("/pagehelper")
	public String pagehelper(Model mm) {
		return "easyui/pagehelper";
	}

	// 分页数据
	@ResponseBody
	@RequestMapping("/pagehelperjson")
	public Result pagehelperjson(Model mm, HttpServletRequest request, HttpServletResponse response, int page, int rows,
			@RequestParam String pageParam) {
		PageParam pageParm = (PageParam) JsonHelper.encodeJsonToObject(pageParam, PageParam.class);
		Result result = new Result();
		pageParm.setPage(page);
		pageParm.setPageSize(rows);
		// 可将分页查询移到service层处理
		// PageHelper.startPage(pageParm.getPage(), pageParm.getPageSize());
		// List<HpzcCgd> list =
		// hpzcCgdService.selectByQuery(pageParm.getSearchContent());
		// PageInfo<HpzcCgd> p = new PageInfo<HpzcCgd>(list);
		// result.setTotal((int) p.getTotal());
		// result.setRows(p.getList());
		return result;
	}

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
	public void updateUser(@RequestParam String id, @RequestParam int uId, @RequestParam String username,
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
		Map<String, Object> map = new HashMap<String, Object>();
		List<HpzcUser> listUser = hpzcUserDao.selectByMap(map);
		System.out.println(listUser);
		return gson.toJson(listUser);

	}

}
