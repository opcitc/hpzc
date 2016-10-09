package com.hpzc.dao.tms;

import com.hpzc.model.tms.HpzcCustomer;

public interface HpzcCustomerMapper {

	int insert(HpzcCustomer record);

	HpzcCustomer selectByPrimaryKey(String cId);

	int update(HpzcCustomer record);
}