package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcXsdDetail;

public interface HpzcXsdDetailMapper {

	int insert(HpzcXsdDetail record);

	List<HpzcXsdDetail> selectByMap(Map<String, Object> map);

	int update(HpzcXsdDetail record);
}