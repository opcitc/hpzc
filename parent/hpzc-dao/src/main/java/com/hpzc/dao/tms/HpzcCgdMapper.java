package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcCgd;

public interface HpzcCgdMapper {

	int insert(HpzcCgd record);

	void batchDelete(List<String> list);

	HpzcCgd selectById(String hId);

	List<HpzcCgd> selectByQuery(Map<String, Object> map);

	int update(HpzcCgd record);

	int selectByMax(String str);

}