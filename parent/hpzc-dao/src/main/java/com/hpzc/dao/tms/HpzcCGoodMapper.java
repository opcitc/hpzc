package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcCGood;

public interface HpzcCGoodMapper {

	int insert(HpzcCGood record);

	HpzcCGood selectByPrimaryKey(String gId);

	int update(HpzcCGood record);
}