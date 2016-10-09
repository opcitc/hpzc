package com.hpzc.service.tms;

import com.hpzc.model.tms.HpzcCGood;

/**
 * 
 * @Description:商品信息
 * @author ：zhengguohui
 * @return ： 2016年8月12日 下午3:07:03
 */
public interface HpzcGoodService {

	public void save(HpzcCGood hpzcCGood);

	public void update(HpzcCGood hpzcCGood);

	public HpzcCGood selectBy(HpzcCGood hpzcCGood);

}
