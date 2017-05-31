package com.hpzc.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 全局常量类
 * 
 * @author 李广
 * @date 2016-5-11
 */
public class GlobalConstants {
	/**是否开启数据加密*/
	public static boolean isEncrypt = false;
	/**登陆用户名*/
	private static String userName = "";
	/**登陆用户code*/
	private static String userCode = "";
	/**类和所属类型映射集合*/
	@SuppressWarnings("serial")
	private static Map<String, ModuleTypeEnum> map = new HashMap<String, ModuleTypeEnum>() {{ 
		put("com.pcitc.web.security.LoginInterceptor", ModuleTypeEnum.login);
	}}; 
	
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		synchronized (userName) {
			GlobalConstants.userName = userName;
		}
	}
	public static String getUserCode() {
		return userCode;
	}
	public static void setUserCode(String userCode) {
		synchronized (userCode) {
			GlobalConstants.userCode = userCode;
		}
	}
	
	/**
	 * 根据类的全路径获取所属模块名称
	 * @param classPath 类全路径
	 * @return
	 */
	public static ModuleTypeEnum getModule(String classPath){
		if(StringUtils.isNotBlank(classPath) && map.containsKey(classPath)){
			return map.get(classPath);
		}
		return ModuleTypeEnum.module_default;
	}
}
