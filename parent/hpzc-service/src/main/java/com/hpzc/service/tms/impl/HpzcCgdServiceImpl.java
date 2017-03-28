package com.hpzc.service.tms.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpzc.common.util.SeqNum;
import com.hpzc.common.util.UUID;
import com.hpzc.dao.tms.HpzcCgdDetailMapper;
import com.hpzc.dao.tms.HpzcCgdMapper;
import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.service.tms.HpzcCgdService;

@Service
public class HpzcCgdServiceImpl implements HpzcCgdService {

	@Autowired
	private HpzcCgdMapper hpzcCgdDao;
	@Autowired
	private HpzcCgdDetailMapper hpzcCgdDetailDao;

	Map<String, Object> map = new HashMap<String, Object>();

	SeqNum seqNum = new SeqNum();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-hh");

	@Override
	public void save(HpzcCgd hpzcCgd) {
		hpzcCgd.sethId(UUID.getUUID());
		hpzcCgd.sethCjrq(new Date());
		hpzcCgd.setIsdelete("0");
		hpzcCgd.sethName(format.format(new Date()));
		// 创建日期
		hpzcCgd.setHzdrq(formatDate.format(new Date()));
		// 获取序列号
		int num = hpzcCgdDao.selectByMax(hpzcCgd.gethName());
		String hNo = seqNum.getSeqNum(num, 5, "CG-");
		System.out.println(hNo);
		hpzcCgd.sethCode(hNo);
		hpzcCgdDao.insert(hpzcCgd);
	}

	@Override
	public void update(HpzcCgd hpzcCgd) {
		hpzcCgd.sethXgrq(new Date());
		hpzcCgdDao.update(hpzcCgd);
	}

	@Override
	public void deleteDetail(HpzcCgd hpzcCgd) {
		hpzcCgdDao.update(hpzcCgd);
	}

	@Override
	public List<HpzcCgd> selectByQuery(Map<String, Object> map) {
		List<HpzcCgd> list = hpzcCgdDao.selectByQuery(map);
		System.out.println(list.size());
		return list;
	}

	@Override
	public void saveDetail(HpzcCgdDetail hpzcCgdDetail) {
		hpzcCgdDetail.setgId(UUID.getUUID());
		hpzcCgdDetail.setgCreate(formatDate.format(new Date()));
		hpzcCgdDetailDao.insert(hpzcCgdDetail);
	}

	@Override
	public void updateDetail(HpzcCgdDetail hpzcCgdDetail) {
		hpzcCgdDetailDao.update(hpzcCgdDetail);
	}

	@Override
	public List<HpzcCgdDetail> selectByQueryDetail(String gCode) {
		map.put("gCode", gCode);
		List<HpzcCgdDetail> list = hpzcCgdDetailDao.selectByMap(map);
		return list;
	}

	@Override
	public void deleteDetail(HpzcCgdDetail hpzcCgdDetail) {
		hpzcCgdDetailDao.update(hpzcCgdDetail);
	}

}
