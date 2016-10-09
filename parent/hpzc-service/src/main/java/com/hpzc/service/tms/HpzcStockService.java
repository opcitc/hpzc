package com.hpzc.service.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcStock;

/**
 * @Description:库存信息
 * @author ：zhengguohui
 * @return ： 2016年8月12日 下午3:05:48
 */
public interface HpzcStockService {

	public void save(HpzcStock hpzcStock);

	public void update(HpzcStock hpzcStock);

	public HpzcStock selectBy(HpzcStock hpzcStock);
	
	public List<HpzcStock> selectByQuery(Map<String, Object> map);

}
