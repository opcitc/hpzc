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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpzc.common.json.JsonHelper;
import com.hpzc.dao.page.Page;
import com.hpzc.dao.page.PageParam;
import com.hpzc.dao.tms.HpzcCgdMapper;
import com.hpzc.model.common.Result;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.service.tms.HpzcCgdService;

@Controller
@RequestMapping("/hpzcCgd")
public class HpzcCgdController {

	@Autowired
	private HpzcCgdMapper hpzcCgdDao;
	@Autowired
	private HpzcCgdService hpzcCgdService;

	@RequestMapping("/hpzcCgdDetail")
	public String hpzcCgdDetail(Model mm, String gCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("hCode", gCode);
		List<HpzcCgd> list = hpzcCgdDao.selectByQuery(map);
		HpzcCgd hpzcCgd = list.get(0);
		mm.addAttribute("hpzcCgd", JsonHelper.encodeObject2Json(hpzcCgd));
		return "hpzcCgd/hpzcCgdDetail";
	}

	// 采购单详情列表数据!
	@ResponseBody
	@RequestMapping(value = "/hpzcCgdDetailData", produces = "text/html;charset=UTF-8")
	public String hpzcCgdDetailData(Model mm, String gCode, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<HpzcCgdDetail> list = hpzcCgdService.selectByQueryDetail(gCode);
		PageInfo<HpzcCgdDetail> p = new PageInfo<HpzcCgdDetail>(list);
		Result result = new Result();
		result.setTotal((int) p.getTotal());
		result.setRows(p.getList());
		return JsonHelper.encodeObject2Json(result);
	}

	// 保存新增采购单详情数据
	@ResponseBody
	@RequestMapping("/hpzcCgdDetailSave")
	public String hpzcCgdSaveDetailJson(Model mm, @RequestParam String row, String gCode) {
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
	public String hpzcCgdData(Model mm, int page, int rows, @RequestParam String pageParam) {
		PageParam pageParm = (PageParam) JsonHelper.encodeJsonToObject(pageParam, PageParam.class);
		pageParm.setPage(page);
		pageParm.setPageSize(rows);
		// PageHelper.startPage(pageParm.getPage(), pageParm.getPageSize());
		PageInfo<HpzcCgd> p = hpzcCgdService.selectByQuery(pageParm);
		Result result = new Result();
		result.setTotal((int) p.getTotal());
		result.setRows(p.getList());
		return JsonHelper.encodeObject2Json(result);
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
