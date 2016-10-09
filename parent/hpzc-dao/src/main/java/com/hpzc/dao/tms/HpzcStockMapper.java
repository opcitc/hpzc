package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcStock;

public interface HpzcStockMapper {

	int insert(HpzcStock record);

	HpzcStock selectByPrimaryKey(String sId);

	int update(HpzcStock record);
	
	List<HpzcStock> selectByQuery(Map<String, Object> map);

}