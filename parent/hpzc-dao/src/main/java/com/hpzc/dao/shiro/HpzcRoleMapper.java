package com.hpzc.dao.shiro;

import java.util.List;
import java.util.Set;

import com.hpzc.model.shiro.HpzcRole;

public interface HpzcRoleMapper {

	int insert(HpzcRole record);

	Set<String> selectRoles(int uid);

}