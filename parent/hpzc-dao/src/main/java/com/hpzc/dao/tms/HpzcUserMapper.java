package com.hpzc.dao.tms;

import java.util.List;
import java.util.Map;

import com.hpzc.model.tms.HpzcUser;

public interface HpzcUserMapper {

	List<HpzcUser> selectByMap(Map<String, Object> map);

	int insert(HpzcUser record);

	HpzcUser selectById(String uId);

	int update(HpzcUser record);

	int selectByNum(Map<String, Object> map);
}