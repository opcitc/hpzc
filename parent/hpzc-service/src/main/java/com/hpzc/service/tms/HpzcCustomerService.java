package com.hpzc.service.tms;

import com.hpzc.model.tms.HpzcCustomer;

/**
 * 
 * @Description:供应商信息
 * @author ：zhengguohui
 * @return ： 2016年8月12日 下午3:07:34
 */
public interface HpzcCustomerService {

	public void save(HpzcCustomer hpzcCustomer);

	public void update(HpzcCustomer hpzcCustomer);

	public HpzcCustomer selectBy(HpzcCustomer hpzcCustomer);

}
