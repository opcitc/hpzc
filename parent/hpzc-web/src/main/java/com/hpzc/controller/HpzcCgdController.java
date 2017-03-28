package com.hpzc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hpzc.common.json.JsonHelper;
import com.hpzc.model.common.PageParam;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.service.tms.HpzcCgdService;

@Controller
@RequestMapping("/hpzcCgd")
public class HpzcCgdController {

	@Autowired
	private HpzcCgdService hpzcCgdService;

	Map<String, Object> map = new HashMap<String, Object>();

	@RequestMapping("/hpzcCgdDetail")
	public String hpzcCgdDetail(Model mm,String gCode) {
		map.put("hCode", gCode);
		List<HpzcCgd> list = hpzcCgdService.selectByQuery(map);
		HpzcCgd hpzcCgd = list.get(0);
		mm.addAttribute("hpzcCgd", JsonHelper.encodeObject2Json(hpzcCgd));
		return "hpzcCgd/hpzcCgdDetail";
	}

	// 采购单详情列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcCgdDetailData", produces = "text/html;charset=UTF-8")
	public String hpzcCgdDetailData(Model mm, String gCode) {
		List<HpzcCgdDetail> list = hpzcCgdService.selectByQueryDetail(gCode);
		return JsonHelper.encodeObject2Json(list);
	}

	// 保存新增采购单详情数据
	@ResponseBody
	@RequestMapping("/hpzcCgdDetailSave")
	public String hpzcCgdSaveDetailJson(Model mm, @RequestParam String row,String gCode) {
		HpzcCgdDetail hpzcCgdDetail = (HpzcCgdDetail) JsonHelper.encodeJsonToObject(row, HpzcCgdDetail.class);
		hpzcCgdDetail.setgCode(gCode);
		hpzcCgdService.saveDetail(hpzcCgdDetail);
		return "1";
	}

	// 保存修改采购单详情数据
	@ResponseBody
	@RequestMapping("/hpzcCgdDetailEdit")
	public String hpzcCgdDetailEdit(Model mm, @RequestParam String row) {
		HpzcCgdDetail hpzcCgdDetail = (HpzcCgdDetail) JsonHelper.encodeJsonToObject(row, HpzcCgdDetail.class);
		hpzcCgdService.updateDetail(hpzcCgdDetail);
		return "1";
	}

	// 删除采购单详情数据
	@ResponseBody
	@RequestMapping("/hpzcCgdDetailRemove")
	public String hpzcCgdDetailRemove(Model mm, @RequestParam String hIds) {
		String[] str = hIds.split(",");
		for (int i = 0; i < str.length; i++) {
			HpzcCgdDetail hpzcCgdDetail = new HpzcCgdDetail();
			hpzcCgdDetail.setgId(str[i]);
			hpzcCgdDetail.setIsdelete("1");
			hpzcCgdService.updateDetail(hpzcCgdDetail);
		}
		return String.valueOf(str.length);
	}

	// 采购单列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcCgdData", produces = "text/html;charset=UTF-8")
	public String hpzcCgdData(Model mm, @RequestParam String pageParam) {
		/*
		 * String msg = ""; try { msg = new
		 * String(pageParam.getBytes("ISO-8859-1"), "UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 * System.out.println(msg);
		 */
		PageParam page = (PageParam) JsonHelper.encodeJsonToObject(pageParam, PageParam.class);
		List<HpzcCgd> list = hpzcCgdService.selectByQuery(page.getSearchContent());
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
		return String.valueOf(str.length);
	}

}
