package com.hpzc.service.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcCgd;
import com.hpzc.model.tms.HpzcCgdDetail;
import com.hpzc.redis.dao.Member;

/**
 * 
 * @Description:采购信息
 * @author ：zhengguohui
 * @return ： 2016年8月12日 下午3:07:20
 */
public interface HpzcCgdService {

	/**
	 * @Description:保存采购单信息
	 * @author ：zhengguohui
	 * @param hpzcCgd
	 * @return ： 2016年10月8日 上午11:08:58
	 */
	public void save(HpzcCgd hpzcCgd);

	/**
	 * @Description:更新采购单信息
	 * @author ：zhengguohui
	 * @param hpzcCgd
	 * @return ： 2016年10月8日 上午11:09:29
	 */
	public void update(HpzcCgd hpzcCgd);

	/**
	 * @Description:删除采购单信息
	 * @author ：zhengguohui
	 * @param hpzcCgd
	 * @return ： 2016年10月8日 上午11:09:42
	 */
	public void deleteDetail(HpzcCgd hpzcCgd);

	/**
	 * @Description:根据条件查询采购单信息
	 * @author ：zhengguohui
	 * @param map
	 * @return
	 * @return ： 2016年10月8日 上午11:10:06
	 */
	public List<HpzcCgd> selectByQuery(Map<String, Object> map);

	/**
	 * @Description:保存采购单详情信息
	 * @author ：zhengguohui
	 * @param hpzcCgdDetail
	 * @return ： 2016年10月8日 上午11:10:32
	 */
	public void saveDetail(HpzcCgdDetail hpzcCgdDetail);

	/**
	 * @Description:更新采购单详情信息
	 * @author ：zhengguohui
	 * @param hpzcCgdDetail
	 * @return ： 2016年10月8日 上午11:10:55
	 */
	public void updateDetail(HpzcCgdDetail hpzcCgdDetail);

	/**
	 * @Description:删除采购单详情信息
	 * @author ：zhengguohui
	 * @param hpzcCgdDetail
	 * @return ： 2016年10月8日 上午11:11:08
	 */
	public void deleteDetail(HpzcCgdDetail hpzcCgdDetail);

	/**
	 * @Description:根据条件查询采购单详情信息
	 * @author ：zhengguohui
	 * @param gCode
	 * @return
	 * @return ： 2016年10月8日 上午11:11:37
	 */
	public List<HpzcCgdDetail> selectByQueryDetail(String gCode);

}
