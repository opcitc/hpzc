package com.hpzc.model.shiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hpzc.model.tms.HpzcUser;
import com.hpzc.service.tms.HpzcUserService;

public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private HpzcUserService hpzcUserService;

	public ShiroRealm() {
		super();
	}

	/**
	 * Shiro 身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		System.out.println("身份验证");
		ShiroToken token = (ShiroToken) authcToken;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", token.getUsername());
		map.put("password", token.getPswd());
		// 数据库查询权限
		List<HpzcUser> list = hpzcUserService.selectByQuery(map);
		HpzcUser user = new HpzcUser();
		// List<HpzcUser> list = hpzcUserService.selectByQuery(map);
		if (list != null && list.size() == 1) {
			user = list.get(0);
			System.out.println("验证通过");
		}
		//
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}

	/**
	 * Shiro权限验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限验证");
		HpzcUser user = new HpzcUser();
		String userId = user.getuId();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据用户ID查询角色（role），放入到Authorization里。
		// Set<String> roles = roleService.findRoleByUserId(userId);
		// info.setRoles(roles);
		// // 根据用户ID查询权限（permission），放入到Authorization里。
		// Set<String> permissions =
		// permissionService.findPermissionByUserId(userId);
		// info.setStringPermissions(permissions);
		return info;
	}

}
