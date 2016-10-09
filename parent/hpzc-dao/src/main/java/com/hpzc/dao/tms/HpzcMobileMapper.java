package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcMobile;

public interface HpzcMobileMapper {

	int insert(HpzcMobile record);

	HpzcMobile selectByPrimaryKey(String phoneId);

	int update(HpzcMobile record);
}