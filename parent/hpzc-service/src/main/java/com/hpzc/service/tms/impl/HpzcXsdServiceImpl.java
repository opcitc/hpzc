package com.hpzc.service.tms.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpzc.common.util.SeqNum;
import com.hpzc.common.util.UUID;
import com.hpzc.dao.tms.HpzcXsdDetailMapper;
import com.hpzc.dao.tms.HpzcXsdMapper;
import com.hpzc.model.tms.HpzcXsd;
import com.hpzc.model.tms.HpzcXsdDetail;
import com.hpzc.service.tms.HpzcXsdService;

@Service
public class HpzcXsdServiceImpl implements HpzcXsdService {

	@Autowired
	private HpzcXsdMapper hpzcXsdDao;
	
	@Autowired
	private HpzcXsdDetailMapper hpzcXsdDetailDao;
	
	
	SeqNum seqNum = new SeqNum();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
	SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-hh");

	@Override
	public void save(HpzcXsd hpzcXsd) {
		hpzcXsd.setxId(UUID.getUUID());
		hpzcXsd.setxCreate(new Date());
		hpzcXsd.sethZdrq(formatDate.format(new Date()));
		hpzcXsd.sethSeqno(format.format(new Date()));
		int num = hpzcXsdDao.selectByMax(hpzcXsd.gethSeqno());
		String xXsdh = seqNum.getSeqNum(num, 5, "XS-");
		hpzcXsd.setIsdelete("0");
		hpzcXsd.setxXsdh(xXsdh);
		hpzcXsdDao.insert(hpzcXsd);
	}

	@Override
	public void update(HpzcXsd hpzcXsd) {
		hpzcXsd.setxModefier(new Date());
		hpzcXsdDao.update(hpzcXsd);
	}

	@Override
	public HpzcXsd selectBy(HpzcXsd hpzcXsd) {
		return hpzcXsdDao.selectById(hpzcXsd.getRemark1());
	}

	@Override
	public List<HpzcXsd> selectByQuery(Map<String, Object> map) {
		List<HpzcXsd> list = hpzcXsdDao.selectByQuery(map);
		return list;
	}

	@Override
	public void delete(List<String> list) {
		hpzcXsdDao.batchDelete(list);
	}

	@Override
	public void saveDetail(HpzcXsdDetail hpzcXsdDetail) {
		hpzcXsdDetail.setxCjrq(new Date());
		hpzcXsdDetailDao.insert(hpzcXsdDetail);
	}

	@Override
	public void updateDetail(HpzcXsdDetail hpzcXsdDetail) {
		hpzcXsdDetail.setxXgrq(new Date());
		hpzcXsdDetailDao.update(hpzcXsdDetail);
	}

	@Override
	public void deleteDetail(HpzcXsdDetail hpzcXsdDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HpzcXsdDetail> selectByQueryDetail(Map<String, Object> map) {
		List<HpzcXsdDetail> list = hpzcXsdDetailDao.selectByMap(map);
		return list;
	}

}
