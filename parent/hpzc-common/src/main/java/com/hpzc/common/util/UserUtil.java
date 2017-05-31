package com.hpzc.common.util;

public class UserUtil {

	
	public static boolean checkIsAdmin(String loginName)
	{
		if(loginName.equals("admin")||loginName.equals("sysadmin"))
		{
			return true;
		}
		else{
			return false;
		}
	}
}
