package com.hpzc.common.util;


/**
 * @ClassName: UUID
 * @Description: 生成主键
 * @Author caolini
 * @Date 2015年12月14日 下午4:52:00 
 *
 */
public class UUID {

	 
    /**
     * @Title: getUUID 
     * @Description: 获取UUID32位字符
     * @param 
     * @return String
     * @throws
     * 
     */
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

   
    /**
     * @Title: getGUID 
     * @Description: 获取GUID36位字符
     * @param 
     * @return String
     * @throws
     * 
     */
    public static String getGUID(){
        return java.util.UUID.randomUUID().toString().toUpperCase();
    }
}
