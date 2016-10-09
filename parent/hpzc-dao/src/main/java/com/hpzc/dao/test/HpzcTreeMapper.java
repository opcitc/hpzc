package com.hpzc.dao.test;

import java.util.List;
import java.util.Map;

import com.hpzc.model.test.HpzcTree;

public interface HpzcTreeMapper {


	List<HpzcTree> selectByQuery(Map<String, Object> map);

}