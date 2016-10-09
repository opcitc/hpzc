package com.hpzc.service.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcXsd;
import com.hpzc.model.tms.HpzcXsdDetail;

/**
 * 
 * @Description:销售信息
 * @author ：zhengguohui
 * @return ： 2016年8月12日 下午3:06:14
 */
public interface HpzcXsdService {
	/**
	 * @Description:销售单保存信息
	 * @author ：zhengguohui
	 * @param hpzcXsd
	 * @return ： 2016年10月8日 上午11:00:34
	 */
	public void save(HpzcXsd hpzcXsd);

	/**
	 * @Description:销售单更新信息
	 * @author ：zhengguohui
	 * @param hpzcXsd
	 * @return ： 2016年10月8日 上午11:01:05
	 */
	public void update(HpzcXsd hpzcXsd);

	/**
	 * @Description:根据ID查询销售单信息
	 * @author ：zhengguohui
	 * @param hpzcXsd
	 * @return
	 * @return ： 2016年10月8日 上午11:01:37
	 */
	public HpzcXsd selectBy(HpzcXsd hpzcXsd);

	/**
	 * @Description:根据条件查询销售单信息
	 * @author ：zhengguohui
	 * @param map
	 * @return
	 * @return ： 2016年10月8日 上午11:02:04
	 */
	public List<HpzcXsd> selectByQuery(Map<String, Object> map);

	/**
	 * @Description:删除销售单信息
	 * @author ：zhengguohui
	 * @param list
	 * @return ： 2016年10月8日 上午11:02:32
	 */
	public void delete(List<String> list);

	/**
	 * @Description:销售单详情
	 * @author ：zhengguohui
	 * @param hpzcXsdDetail
	 * @return ： 2016年10月8日 上午11:07:14
	 */
	public void saveDetail(HpzcXsdDetail hpzcXsdDetail);

	/**
	 * @Description:更新销售单详情信息
	 * @author ：zhengguohui
	 * @param hpzcXsdDetail
	 * @return ： 2016年10月8日 上午11:07:38
	 */
	public void updateDetail(HpzcXsdDetail hpzcXsdDetail);

	/**
	 * @Description:删除销售单详情信
	 * @author ：zhengguohui
	 * @param hpzcXsdDetail
	 * @return ： 2016年10月8日 上午11:08:01
	 */
	public void deleteDetail(HpzcXsdDetail hpzcXsdDetail);

	/**
	 * @Description:销售单详情信息查询
	 * @author ：zhengguohui
	 * @param gCode
	 * @return
	 * @return ： 2016年10月8日 上午11:08:26
	 */
	public List<HpzcXsdDetail> selectByQueryDetail(Map<String, Object> map);

}