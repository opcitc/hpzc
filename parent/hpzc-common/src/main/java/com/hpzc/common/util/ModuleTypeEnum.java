package com.hpzc.common.util;

/**
 * 模块类型名称枚举
 * 
 * @author 李广
 * @date 2016-5-11
 */
public enum ModuleTypeEnum {

	/**默认模块名称*/
	module_default("系统"),
	/**登陆*/
	login("登陆"),
	/**退出*/
	logout("退出");

	@Override
	public String toString() {
		return this.val;
	}

	//成员变量
	private final String val;

	private ModuleTypeEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
