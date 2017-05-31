package com.hpzc.common.xml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class XmlHelper {

	private static final String defaultRootElement = "root";
	
	public static String map2xml(Map<String, String> map )
	{
		return map2xml(map, defaultRootElement, null);
		
	}
	
	public static String map2xml(Map<String, String> map, NameTransfer rule )
	{
		return map2xml(map, defaultRootElement, rule);
		
	}
	
	public static String map2xml(Map<String, String> map, String rootElement)
	{
		Document doc = DocumentHelper.createDocument();
        Element body = DocumentHelper.createElement(rootElement);
        doc.add(body);
         
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            
            if (StringUtils.isNotEmpty(key)) {
                String value = map.get(key);
                Element element = DocumentHelper.createElement(key);
                if (value != null) {
                	element.setText(value);
                }
                body.add(element);
            }
        }
        
		return doc.asXML();
		//return null;
		
	}
	
	public static String map2xml(Map<String, String> map, String rootElement, NameTransfer rule)
	{
		Document doc = DocumentHelper.createDocument();
        Element body = DocumentHelper.createElement(rootElement);
        doc.add(body);
         
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            
            if (StringUtils.isNotEmpty(key)) {
                String value = map.get(key);
                
                if(rule!=null)
                	key = rule.toXmlElementName(key);
                
                Element element = DocumentHelper.createElement(key);
                if (value != null) {
                	element.setText(value);
                }
                body.add(element);
            }
        }
        
		return doc.asXML();
		//return null;
		
	}
		
	public static Map<String, String> xml2map(String xml, NameTransfer rule)  throws DocumentException 
	{
		return xml2map(xml, defaultRootElement, rule);
	}
	
	public static Map<String, String> xml2map(String xml, String rootElement, NameTransfer rule)  throws DocumentException 
	{ 
		Document doc = DocumentHelper.parseText(xml);
        Element body = (Element) doc.getRootElement();
        
        Map<String, String> map = new HashMap<>();
        
        if (body != null) {
            @SuppressWarnings("unchecked")
			List<Element> elements = body.elements();
            for (Element element : elements) {
                String key = element.getName();
                if (StringUtils.isNotEmpty(key)) {
                    String value = element.getText().trim();
                    
                    if(rule!=null)
                    	key = rule.toXmlElementName(key);
                    map.put(key, value);
                }
            }
        }
        return map;
         
		//return null;
	}
	/**
	 * 将xml字符串转为map
	 *@param xml
	 *@return
	 *@throws DocumentException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xml2map(String xml)  throws DocumentException 
	{ 
		Document doc = DocumentHelper.parseText(xml);
        Element body = (Element) doc.getRootElement();
        
        Map<String, String> map = new HashMap<>();
        
        if (body != null) {
            List<Element> elements = body.elements();
            for (Element element : elements) {
                String key = element.getName();
                if (StringUtils.isNotEmpty(key)) {
                    String value = element.getText().trim();
                    map.put(key, value);
                }
            }
        }
        return map;
         
		//return null;
	}
	
}
