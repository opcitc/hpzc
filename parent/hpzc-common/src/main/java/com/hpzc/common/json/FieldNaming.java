package com.hpzc.common.json;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingStrategy;

public class FieldNaming implements FieldNamingStrategy {

	private Map<String, String> map = new HashMap<String, String>();
	 
	public FieldNaming(Map<String, String> namingMap)
	{
		map.putAll(namingMap);
	}
	
	@Override
	public String translateName(Field field) { 
		String key = field.getName();
		if(map.containsKey(key))
			return map.get(key);
		else
			return key;
	}

}
