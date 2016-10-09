package com.hpzc.common.json;
 
import java.util.HashSet;
import java.util.Set;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class FieldFilter implements ExclusionStrategy {
 
	private Set<String> fieldNames = new HashSet<String>();
	private boolean skipIfContain;
	
	public FieldFilter(Set<String> fields, boolean skipIfContain)
	{
		this.skipIfContain = skipIfContain;
		fieldNames.addAll(fields);
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> c) {
		return false;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) { 
		
//		System.out.println("getDeclaredClass:" + f.getDeclaredClass().getName());
//		System.out.println("getDeclaringClass:" +f.getDeclaringClass().getName());
//		System.out.println("name:" +f.getName());
		
		boolean isContain = fieldNames.contains(f.getName()) 
				|| 
			fieldNames.contains(f.getDeclaringClass().getName() + '.' + f.getName()); 
		
		return isContain == skipIfContain;
	}
	 


}
