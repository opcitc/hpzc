package com.hpzc.model.shiro;

import org.apache.shiro.SecurityUtils;

import com.hpzc.model.tms.HpzcUser;

/**
 * 
 * <p>
 * 
 * <p>
 * 
 * 区分 责任人 日期 说明<br/>
 * 创建 周柏成 2014年3月3日 <br/>
 * <p>
 * 
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年3月3日
 * 
 *          Shiro管理下的Token工具类
 */
public class TokenManager {

	/**
	 * 获取当前登录的用户User对象
	 * 
	 * @return
	 */
	public static HpzcUser getToken() {
		HpzcUser token = (HpzcUser) SecurityUtils.getSubject().getPrincipal();
		return token;
	}

	/**
	 * 获取当前用户NAME
	 * 
	 * @return
	 */
	public static String getNickname() {
		return getToken().getName();
	}

	/**
	 * 获取当前用户ID
	 * 
	 * @return
	 */
	public static int getUserId() {
		return getToken() == null ? null : getToken().getuId();
	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @param rememberMe
	 * @return
	 */
	public static HpzcUser login(HpzcUser user, Boolean rememberMe) {
		ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
		token.setRememberMe(rememberMe);
		SecurityUtils.getSubject().login(token);
		return getToken();
	}

	/**
	 * 判断是否登录
	 * 
	 * @return
	 */
	public static boolean isLogin() {
		return null != SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}

}
