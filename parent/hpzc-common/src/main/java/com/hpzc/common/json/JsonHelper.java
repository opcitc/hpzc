package com.hpzc.common.json;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Json处理器<br>
 * 
 * @author OSWorks-XC
 * @since 2009-07-07
 */
public class JsonHelper {

	public static final String encodeObject2Json(Object pObject, JsonRule rule) {
		
		String jsonString = "[]";
		
		if (pObject != null) {
			GsonBuilder builder = new GsonBuilder();
			
			if(rule!=null){
				if(StringUtils.isNotEmpty(rule.getDataFormat()))
					builder.setDateFormat(rule.getDataFormat());
			
				if(rule.getMatchField().size()>0)
					builder.setExclusionStrategies(new FieldFilter(rule.getMatchField(), false));
				else if(rule.getSkipField().size()>0)
					builder.setExclusionStrategies(new FieldFilter(rule.getSkipField(), true));
				
				if(rule.getRenameField().size()>0)
					builder.setFieldNamingStrategy(new FieldNaming(rule.getRenameField()));
				
				if(rule.isSerializeNull())
					builder.serializeNulls();
			}	
				
			Gson gson = builder.create(); 
			jsonString = gson.toJson(pObject);
		}

		
//		if (log.isInfoEnabled()) {
//			log.info("序列化后的JSON资料输出:\n" + jsonString);
//		}
		return jsonString;
	
	}
	 
	public static final String encodeObject2Json(Object pObject) {
		
		return encodeObject2Json(pObject, (JsonRule) null);
	
	}
 
	public static final String encodeObject2Json(Object pObject, String pFormatString) {
		
		return encodeObject2Json(pObject, pFormatString, false);
	
	}
	
	public static final String encodeObject2Json(Object pObject, String pFormatString, boolean serializeNull) {
		
		JsonRule rule = new JsonRule(pFormatString);
		rule.setSerializeNull(serializeNull);
		return encodeObject2Json(pObject, rule);
	
	} 
	
	public static final String encodeObject2Json(Object pObject, boolean serializeNull) {
		
		JsonRule rule = new JsonRule();
		rule.setSerializeNull(serializeNull);
		return encodeObject2Json(pObject, rule);
	
	} 
	
	public static final <T> Object encodeJsonToObject(String json, Class<T> clazz){
		Gson gson = new Gson(); 
		return gson.fromJson(json, clazz);
	}
	
	public static final <T> T encodeJsonToObject(String json, Type typeOfT){
		Gson gson = new Gson(); 
		return gson.fromJson(json, typeOfT);
	}
	
	public static final <T> List<T> encodeJsonToList(String json, Class<T> clazz){
		Gson gson = new Gson();
		return gson.fromJson(json, new TypeToken<List<T>>(){}.getType()); 
		 
	}

	/**
	 * 将分页信息压入JSON字符串
	 * 此类内部使用,不对外暴露
	 * @param JSON字符串
	 * @param totalCount
	 * @return 返回合并后的字符串
	 */
//	private static String encodeJson2PageJson(String jsonString, Integer totalCount) {
//		jsonString = "{TOTALCOUNT:" + totalCount + ", ROOT:" + jsonString + "}";
//		if (log.isInfoEnabled()) {
//			log.info("合并后的JSON资料输出:\n" + jsonString);
//		}
//		return jsonString;
//	}

//	/**
//	 * 直接将List转为分页所需要的Json资料格式
//	 * 
//	 * @param list
//	 *            需要编码的List对象
//	 * @param totalCount
//	 *            记录总数
//	 * @param pDataFormat
//	 *            时间日期格式化,传null则表明List不包含日期时间属性
//	 */
//	public static final String encodeList2PageJson(List<?> list, Long totalCount, String dataFormat) {
//		
//		String subJsonString = "";
//		if (StringUtils.isEmpty(dataFormat)) {
//			subJsonString = encodeObject2Json(list);
//		} else {
//			subJsonString = encodeObject2Json(list, dataFormat);
//		}
//		String jsonString = "{TOTALCOUNT:" + totalCount + ", ROOT:" + subJsonString + "}";
//		if (log.isInfoEnabled()) {
//			log.info("序列化后的JSON资料输出:\n" + jsonString);
//		}
//		return jsonString;
//	}
//	
//
//
//	/**
//	 * 将数据系列化为表单数据填充所需的Json格式
//	 * 
//	 * @param pObject
//	 *            待系列化的对象
//	 * @param pFormatString
//	 *            日期时间格式化,如果为null则认为没有日期时间型字段
//	 * @return
//	 */
//	public static String encodeMap2FormLoadJson(Map<?,?> map, String pFormatString) {
//		
//		String jsonString = "";
//		String sunJsonString = "";
//		if (StringUtils.isEmpty(pFormatString)) {
//			sunJsonString = encodeObject2Json(map);
//		} else {
//			sunJsonString = encodeObject2Json(map, pFormatString);
//		}
//		jsonString = "{success:"
//				+ (StringUtils.isEmpty((String) map.get("success")) ? "true" : map.get("success")) + ",data:"
//				+ sunJsonString + "}";
//		if (log.isInfoEnabled()) {
//			log.info("序列化后的JSON资料输出:\n" + jsonString);
//		}
//		
//		return jsonString;
//	}
//
//	/**
//	 * 将单一Json对象解析为DTOJava对象
//	 * 
//	 * @param jsonString
//	 *            简单的Json对象
//	 * @return dto
//	 */
//	public static Map<String, Object> convertJson2MapObject(String jsonString) {
//		
//		JsonParser parser = new JsonParser();  
//        JsonObject jsonObj = parser.parse(jsonString).getAsJsonObject();  
//        
//		return toMap(jsonObj);
//	}
//	
//	private static Map<String, Object> toMap(JsonObject json){  
//        Map<String, Object> map = new HashMap<String, Object>();  
//        
//        Set<Entry<String, JsonElement>> entrySet = json.entrySet();  
//        for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ){  
//            Entry<String, JsonElement> entry = iter.next();  
//            String key = entry.getKey();  
//            Object value = entry.getValue();  
//            if(value instanceof JsonArray)  
//                map.put((String) key, toList((JsonArray) value));  
//            else if(value instanceof JsonObject)  
//                map.put((String) key, toMap((JsonObject) value));  
//            else  
//                map.put((String) key, value);  
//        }  
//        return map;  
//    }  
//	
//	 private static List<Object> toList(JsonArray json){  
//	        List<Object> list = new ArrayList<Object>();  
//	        for (int i=0; i<json.size(); i++){  
//	            Object value = json.get(i);  
//	            if(value instanceof JsonArray){  
//	                list.add(toList((JsonArray) value));  
//	            }  
//	            else if(value instanceof JsonObject){  
//	                list.add(toMap((JsonObject) value));  
//	            }  
//	            else{  
//	                list.add(value);  
//	            }  
//	        }  
//	        return list;  
//	    }  
//	
//
//	/**
//	 * 将复杂Json资料格式转换为List对象
//	 * 
//	 * @param jsonString
//	 *            复杂Json对象,格式必须符合如下契约<br>
//	 *            {"1":{"name":"托尼.贾","age":"27"},
//	 *            "2":{"name":"甄子丹","age":"72"}}
//	 * @return List
//	 */
//	public static Collection<Object> convertJson2MapArray(String jsonString) {
//		
//		Map<String, Object> map = convertJson2MapObject(jsonString);
//		return map.values();
//		 
//	}
//	
//	public static Map<String, Object> parseJSON2Map(String jsonStr){
//	    Map<String, Object> map = new HashMap<String, Object>();
//	    //最外层解析
//	    JSONObject json = JSONObject.fromObject(jsonStr);
//	    for(Object k : json.keySet()){
//	      Object v = json.get(k); 
//	      //如果内层还是数组的话，继续解析
//	      if(v instanceof JSONArray){
//	        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//	        Iterator<JSONObject> it = ((JSONArray)v).iterator();
//	        while(it.hasNext()){
//	          JSONObject json2 = it.next();
//	          list.add(parseJSON2Map(json2.toString()));
//	        }
//	        map.put(k.toString(), list);
//	      } else {
//	        map.put(k.toString(), v);
//	      }
//	    }
//	    return map;
//	  }
	
}
