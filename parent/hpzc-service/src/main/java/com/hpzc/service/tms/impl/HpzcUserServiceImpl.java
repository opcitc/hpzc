package com.hpzc.service.tms.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpzc.common.util.Md5;
import com.hpzc.dao.shiro.HpzcPermissionMapper;
import com.hpzc.dao.shiro.HpzcRoleMapper;
import com.hpzc.dao.tms.HpzcUserMapper;
import com.hpzc.model.tms.HpzcUser;
import com.hpzc.service.tms.HpzcUserService;

@Service("hpzcUserService")
public class HpzcUserServiceImpl implements HpzcUserService {

	@Autowired
	private HpzcUserMapper hpzcUserDao;
	@Autowired
	private HpzcRoleMapper hpzcRoleDao;
	@Autowired
	private HpzcPermissionMapper hpzcPermissionDao;

	@Override
	public void save(HpzcUser hpzcUser) {
		// String password = Md5.string2MD5(hpzcUser.getPassword());
		// hpzcUser.setPassword(password);
		hpzcUserDao.insert(hpzcUser);

	}

	@Override
	public void update(HpzcUser hpzcUser) {
		// String password = Md5.string2MD5(hpzcUser.getPassword());
		// hpzcUser.setPassword(password);
		hpzcUserDao.update(hpzcUser);
	}

	@Override
	public List<HpzcUser> selectByQuery(Map<String, Object> map) {
		List<HpzcUser> list = hpzcUserDao.selectByMap(map);
		return list;
	}

	@Override
	public Set<String> selectRoles(int uid) {
		// TODO Auto-generated method stub
		return hpzcRoleDao.selectRoles(uid);
	}

	@Override
	public Set<String> selectPermissions(int rid) {
		// TODO Auto-generated method stub
		return hpzcPermissionDao.selectPermissions(rid);
	}

}
