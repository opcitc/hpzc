package com.hpzc.common.util;

import java.lang.reflect.Field;

public class LgUtil {
	
	public static void convert(Class<?> source,Class<?> target){
		Field [] sFileds = source.getDeclaredFields();
		Field [] tFileds = target.getDeclaredFields();
		
		for(int i=0; i< tFileds.length; i++)
        {
            String tName = tFileds[i].getName();
            boolean isExist = false;
            for(int j=0;j<sFileds.length;j++){
            	String sName = sFileds[j].getName();
            	
            	if(tName.equals(sName)){
            		isExist = true;
            		sName = sName.substring(0,1).toUpperCase() + sName.substring(1);
            		System.out.println("e.set"+sName+"(zi.get"+sName+"());");
            		break;
            	}
            }
            
            if(!isExist){
            	tName = tName.substring(0,1).toUpperCase() + tName.substring(1);
            	System.out.println("e.set"+tName+"(zi.get);");
            }
        } 
	}
	
	/**
	 * 将字符串中的字符替换成指定字符
	 * @param str 要替换的字符串
	 * @param regex 被替换对的字符
	 * @param replacement 新的字符
	 * @return
	 */
	public static String replaceAll(Object str,String regex,String replacement){
		if(str == null){
			return null;
		}else{
			String newStr = String.valueOf(str);
			return newStr.replaceAll(regex, replacement);
		}
	}
	
}
