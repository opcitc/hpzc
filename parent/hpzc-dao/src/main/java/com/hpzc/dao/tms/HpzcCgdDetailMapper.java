package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcCgdDetail;

public interface HpzcCgdDetailMapper {

	int insert(HpzcCgdDetail record);

	List<HpzcCgdDetail> selectByMap(Map<String, Object> map);

	int update(HpzcCgdDetail record);

}