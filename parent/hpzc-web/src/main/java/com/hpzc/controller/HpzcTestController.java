package com.hpzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.dao.test.HpzcTreeMapper;
import com.hpzc.model.test.HpzcTree;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.redis.dao.Member;
import com.hpzc.redis.dao.MemberDao;
import com.hpzc.service.tms.HpzcCgdService;

import redis.clients.jedis.Transaction;

@Controller
@RequestMapping("/hpzcTest")
public class HpzcTestController {

	@Autowired
	private HpzcCgdService hpzcCgdService;

	@Autowired
	private HpzcTreeMapper hpzcTree;

	Map<String, Object> map = new HashMap<String, Object>();

	@RequestMapping("/tabs")
	public String tabs() {
		return "easyui/tabs";
	}

	@RequestMapping("/hpzcTest")
	public String hpzcCgd() {
		return "easyui/tree";
	}

	// 采购单列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcTreeData", produces = "text/html;charset=UTF-8")
	public String hpzcTreeData(Model mm, @RequestParam(defaultValue = "0") String id) {
		System.out.println(id);
		map.put("nid", id);
		List<HpzcTree> list = hpzcTree.selectByQuery(map);
		return JsonHelper.encodeObject2Json(list);
	}

	// 保存新增数据
	@ResponseBody
	@RequestMapping("/hpzcCgdSave")
	public String hpzcCgdSaveJson(Model mm, @RequestParam String row, HttpSession session) {
		session.getAttribute("");
		HpzcCgd hpzcCgd = (HpzcCgd) JsonHelper.encodeJsonToObject(row, HpzcCgd.class);
		hpzcCgdService.save(hpzcCgd);
		return "1";
	}

	// 保存修改数据
	@ResponseBody
	@RequestMapping("/hpzcCgdEdit")
	public String hpzcCgdEdit(Model mm, @RequestParam String row) {
		HpzcCgd hpzcCgd = (HpzcCgd) JsonHelper.encodeJsonToObject(row, HpzcCgd.class);
		hpzcCgdService.update(hpzcCgd);
		return "1";
	}

	// 删除数据
	@ResponseBody
	@RequestMapping("/hpzcCgdRemove")
	public String hpzcCgdRemove(Model mm, @RequestParam String hIds) {
		String[] str = hIds.split(",");
		for (int i = 0; i < str.length; i++) {
			HpzcCgd hpzcCgd = new HpzcCgd();
			hpzcCgd.sethId(str[i]);
			hpzcCgd.setIsdelete("1");
			hpzcCgdService.update(hpzcCgd);
		}
		// 批量删除!
		// hpzcCgdService.delete(list);
		return String.valueOf(str.length);
	}

}
