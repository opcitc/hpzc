package com.hpzc.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * KeyValue配置类
* @ClassName: PropertiesUtils 
* @Description: 
* @author 李栋
* @date 2016-02-17
*
 */
public class PropertiesUtil {

	private String fileName;
	public PropertiesUtil(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * 获得数据库配置信息
	 * @return
	 * @throws IOException 
	 */
	private Properties loadProperties() throws IOException{
		Properties p = null;
		InputStream inputStream = null;
		try {
			p = new Properties();
			Resource resource = new ClassPathResource(this.fileName);
			inputStream = resource.getInputStream();
			p.load(inputStream);
		} catch (IOException e) {
			if(inputStream!=null){
				inputStream.close();
			}
			throw e;
		}
		return p;
	}
	
	private Properties properties;	
	//获取值
	public String getValue(String key){
		if(properties == null) {
			try
			{
				properties = this.loadProperties();
			}
			catch(IOException e)
			{
				System.out.print(e.getMessage());
			}
		}
		if(properties != null) {			
			return properties.getProperty(key);
		}
		return null;
	}	
	
	
	public Set<Entry<Object, Object>> getData(){
		if(properties == null) {
			try
			{
				properties = this.loadProperties();
			}
			catch(IOException e)
			{
				System.out.print(e.getMessage());
			}
		}
		if(properties != null) {			

			return properties.entrySet();
			//return properties.getProperty(key);
		}
		
		return null;
	}



}