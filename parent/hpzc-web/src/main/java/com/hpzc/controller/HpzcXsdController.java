package com.hpzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.dao.page.PageParam;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.model.tms.HpzcXsd;
import com.hpzc.model.tms.HpzcXsdDetail;
import com.hpzc.service.tms.HpzcXsdService;

@Controller
@RequestMapping("/hpzcXsd")
public class HpzcXsdController {

	@Autowired
	private HpzcXsdService hpzcXsdService;

	Map<String, Object> map = new HashMap<String, Object>();

	// 销售单详情界面
	@RequestMapping("/hpzcXsdDetail")
	public String hpzcXsdDetail(Model mm, String xXsdh) {
		map.put("xXsdh", xXsdh);
		List<HpzcXsd> list = hpzcXsdService.selectByQuery(map);
		HpzcXsd hpzcXsd = list.get(0);
		mm.addAttribute("hpzcXsd", JsonHelper.encodeObject2Json(hpzcXsd));
		return "hpzcXsd/hpzcXsdDetail";
	}

	// 销售单详情列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcXsdDetailData", produces = "text/html;charset=UTF-8")
	public String hpzcCgdDetailData(Model mm, String xXsdh) {
		map.put("xXsdh", xXsdh);
		List<HpzcXsdDetail> list = hpzcXsdService.selectByQueryDetail(map);
		return JsonHelper.encodeObject2Json(list);
	}

	// 保存新增销售单详情数据
	@ResponseBody
	@RequestMapping("/hpzcXsdDetailSave")
	public String hpzcXsdDetailSave(Model mm, @RequestParam String row, String xXsdh) {
		HpzcXsdDetail hpzcXsdDetail = (HpzcXsdDetail) JsonHelper.encodeJsonToObject(row, HpzcXsdDetail.class);
		hpzcXsdDetail.setxXsdh(xXsdh);
		hpzcXsdService.saveDetail(hpzcXsdDetail);
		return "1";
	}

	// 更新销售单详情数据
	@ResponseBody
	@RequestMapping("/hpzcXsdDetailEdit")
	public String hpzcXsdDetailEdit(Model mm, @RequestParam String row) {
		HpzcXsdDetail hpzcXsdDetail = (HpzcXsdDetail) JsonHelper.encodeJsonToObject(row, HpzcXsdDetail.class);
		hpzcXsdService.updateDetail(hpzcXsdDetail);
		return "1";
	}

	// 删除销售单详情数据
	@ResponseBody
	@RequestMapping("/hpzcXsdDetailRemove")
	public String hpzcXsdDetailRemove(Model mm, @RequestParam String xIds) {
		String[] str = xIds.split(",");
		for (int i = 0; i < str.length; i++) {
			HpzcXsdDetail hpzcXsdDetail = new HpzcXsdDetail();
			hpzcXsdDetail.setxId(str[i]);
			hpzcXsdDetail.setIsdelete("1");
			hpzcXsdService.updateDetail(hpzcXsdDetail);
		}
		return String.valueOf(str.length);
	}

	// 销售单列表数据
	@ResponseBody
	@RequestMapping(value = "/hpzcXsdData", produces = "text/html;charset=UTF-8")
	public String hpzcCgdData(@RequestParam String pageParam) {
		PageParam page = (PageParam) JsonHelper.encodeJsonToObject(pageParam, PageParam.class);
		List<HpzcXsd> list = hpzcXsdService.selectByQuery(page.getSearchContent());
		return JsonHelper.encodeObject2Json(list);
	}

	// 保存数据
	@ResponseBody
	@RequestMapping("/hpzcXsdSave")
	public String hpzcXsdSave(@RequestParam String row) {
		HpzcXsd hpzcXsd = (HpzcXsd) JsonHelper.encodeJsonToObject(row, HpzcXsd.class);
		hpzcXsdService.save(hpzcXsd);
		return "1";
	}

	// 修改数据
	@ResponseBody
	@RequestMapping("/hpzcXsdEdit")
	public String hpzcCgdEdit(Model mm, @RequestParam String row) {
		HpzcXsd hpzcXsd = (HpzcXsd) JsonHelper.encodeJsonToObject(row, HpzcXsd.class);
		hpzcXsdService.update(hpzcXsd);
		return "1";
	}

	// 修改数据
	@ResponseBody
	@RequestMapping("/hpzcXsdRemove")
	public String hpzcXsdRemove(Model mm, @RequestParam String hIds) {
		String[] str = hIds.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
			list.add(str[i]);
		}
		// 批量删除!
		hpzcXsdService.delete(list);
		return String.valueOf(str.length);
	}

}
