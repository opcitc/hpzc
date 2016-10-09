package com.hpzc.service.tms.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpzc.dao.tms.HpzcStockMapper;
import com.hpzc.model.tms.HpzcStock;
import com.hpzc.service.tms.HpzcStockService;

@Service
public class HpzcStockServiceImpl implements HpzcStockService {

	// Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	private HpzcStockMapper hpzcStockDao;

	@Override
	public void save(HpzcStock hpzcStock) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(HpzcStock hpzcStock) {
		// TODO Auto-generated method stub

	}

	@Override
	public HpzcStock selectBy(HpzcStock hpzcStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HpzcStock> selectByQuery(Map<String, Object> map) {
		List<HpzcStock> list = hpzcStockDao.selectByQuery(map);
		return list;
	}

}
