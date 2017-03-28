package com.hpzc.redis.dao;

import java.util.List;

public interface MemberDao {

	// 增加数据
	boolean add(Member member);

	// 增加数据集合形式
	public boolean add(List<Member> list);

	// 删除单个key
	void delete(String key);

	// 删除多个
	void batchDelete(List<String> keys);

	// 获取某key的value
	Member get(String keyId);

	// 更新某个key的数据
	public boolean update(Member member);

}
