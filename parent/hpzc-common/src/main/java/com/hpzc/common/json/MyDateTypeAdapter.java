package com.hpzc.common.json; 
 
/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone; 
 
/**
 * Adapter for Date. Although this class appears stateless, it is not.
 * DateFormat captures its time zone and locale when it is created, which gives
 * this class state. DateFormat isn't thread safe either, so this class has
 * to synchronize its read and write methods.
 */
public final class MyDateTypeAdapter extends TypeAdapter<Date> {
  public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
    @SuppressWarnings("unchecked") // we use a runtime check to make sure the 'T's equal
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
      return typeToken.getRawType() == Date.class ? (TypeAdapter<T>) new MyDateTypeAdapter() : null;
    }
  };

  private final DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
  private final DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private final DateFormat df3 = buildIso8601Format();
  
  private static DateFormat buildIso8601Format() {
	    DateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
	    iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
	    return iso8601Format;
	  }
  
 
  @Override public Date read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    }
    return deserializeToDate(in.nextString());
  }
  
//	private boolean isNumeric(String str){
//		Pattern p = Pattern.compile("[0-9]*");
//		return p.matcher(str).matches();
//	 
//	}

  private synchronized Date deserializeToDate(String json) {
	  try {
		  
		 
//		  if(isNumeric(json))
		  //{
			  //long time = Long.parseLong(json);
			  //return new Date(time);
		  //}
		  if(json.indexOf("T")>0)
		  {
			  return df3.parse(json);
		  }
		  else 
		  if(json.indexOf(":")>0)
		  {
			  return df2.parse(json);
		  }else{
			  return df1.parse(json);
		  }
	  } catch (ParseException e) {
	      throw new JsonSyntaxException(json, e);
	  }
	  
//    try {
//      return df1.parse(json);
//    } catch (ParseException ignored) {
//    }
//    try {
//      return df2.parse(json);
//    } catch (ParseException ignored) {
//    }
//    try {
//      return df3.parse(json);
//    } catch (ParseException e) {
//      throw new JsonSyntaxException(json, e);
//    }
  }

  @Override public synchronized void write(JsonWriter out, Date value) throws IOException {
    if (value == null) {
      out.nullValue();
      return;
    }
    String dateFormatAsString = df2.format(value);
    out.value(dateFormatAsString);
  }
}


