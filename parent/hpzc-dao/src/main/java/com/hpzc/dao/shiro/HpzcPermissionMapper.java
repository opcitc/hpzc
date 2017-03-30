package com.hpzc.dao.shiro;

import java.util.List;
import java.util.Set;

import com.hpzc.model.shiro.HpzcPermission;

public interface HpzcPermissionMapper {

	int insert(HpzcPermission record);

	Set<String> selectPermissions(int rid);

}