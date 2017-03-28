package com.hpzc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.common.util.Md5;
import com.hpzc.dao.test.HpzcTreeMapper;
import com.hpzc.model.common.PageParam;
import com.hpzc.model.test.HpzcTree;
import com.hpzc.model.tms.HpzcUser;
import com.hpzc.service.tms.HpzcUserService;

@Controller
@RequestMapping("/hpzcUser")
public class HpzcUserController {

	@Autowired
	private HpzcUserService hpzcUserService;
	@Autowired
	private HpzcTreeMapper hpzcTree;

	Map<String, Object> map = new HashMap<String, Object>();

	// 用户列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcUserJson", produces = "text/html;charset=UTF-8")
	public String hpzcUserJson(Model mm) {
		List<HpzcUser> list = hpzcUserService.selectByQuery(map);
		return JsonHelper.encodeObject2Json(list);
	}

	// 用户列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcUserData", produces = "text/html;charset=UTF-8")
	public String hpzcUserData(Model mm, @RequestParam String pageParam) {
		PageParam page = (PageParam) JsonHelper.encodeJsonToObject(pageParam, PageParam.class);
		List<HpzcUser> list = hpzcUserService.selectByQuery(page.getSearchContent());
		return JsonHelper.encodeObject2Json(list);
	}

	// 保存新增用户数据
	@ResponseBody
	@RequestMapping("/hpzcUserSave")
	public String hpzcUserSave(Model mm, @RequestParam String row, HttpSession session) {
		HpzcUser hpzcUser = (HpzcUser) JsonHelper.encodeJsonToObject(row, HpzcUser.class);
		hpzcUserService.save(hpzcUser);
		return "1";
	}

	// 保存修改用户数据
	@ResponseBody
	@RequestMapping("/hpzcUserEdit")
	public String hpzcCgdEdit(Model mm, @RequestParam String row) {
		HpzcUser hpzcUser = (HpzcUser) JsonHelper.encodeJsonToObject(row, HpzcUser.class);
		hpzcUserService.update(hpzcUser);
		return "1";
	}

	// 删除用户数据
	@ResponseBody
	@RequestMapping("/hpzcUserRemove")
	public String hpzcCgdRemove(Model mm, @RequestParam String hIds) {
		String[] str = hIds.split(",");
		for (int i = 0; i < str.length; i++) {
			HpzcUser hpzcUser = new HpzcUser();
			hpzcUser.setuId(str[i]);
			hpzcUser.setIsdelete("1");
			hpzcUserService.update(hpzcUser);
		}
		return String.valueOf(str.length);
	}

	@ResponseBody
	@RequestMapping("/nav")
	public String test(String id) {
		String nid = "0";
		if (!StringUtils.isEmpty(id)) {
			nid = id;
		}
		map.put("nid", nid);
		List<HpzcTree> list = hpzcTree.selectByQuery(map);
		// List<MenuTree> list = new ArrayList<MenuTree>();
		return JsonHelper.encodeObject2Json(list);
	}

	@ResponseBody
	@RequestMapping("/indexinfo")
	public String indexinfo(HttpServletRequest request, HttpServletResponse response, HttpSession hession) {
		// 验证登录增加权限控制!
		String username = request.getParameter("manager");
		String password = request.getParameter("password");
		String pass = Md5.string2MD5(password);
		map.put("username", username);
		map.put("password", pass);
		System.out.println("IP:" + request.getRemoteAddr());
		System.out.println("IP:" + request.getRemoteHost());
		System.out.println("IP:" + request.getRemotePort());
		System.out.println("IP:" + request.getRemoteUser());
		List<HpzcUser> list = hpzcUserService.selectByQuery(map);
		if (list != null && list.size() == 1) {
			String user1 = list.get(0).getName();
			// 登录成功!将用户信息放入session中
			hession.setAttribute("user", user1);
			System.out.println(hession.getAttribute("user"));
			// 可以考虑加入缓存:Cookie
			return "1";
		} else {
			// 登录失败!将用户信息放入session中
			return "0";
		}
	}
}
