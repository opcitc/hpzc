package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcXsd;

public interface HpzcXsdMapper {

	int insert(HpzcXsd record);

	HpzcXsd selectById(String xId);

	int update(HpzcXsd record);

	List<HpzcXsd> selectByQuery(Map<String, Object> map);

	void batchDelete(List<String> list);

	int selectByMax(String str);
}