package com.hpzc.common.util;

import com.hpzc.common.json.JsonHelper;

public class RetDataModel {

	private Boolean success;
	private String msg;
	private Object data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static String GetRetDataByJson(Boolean success, String msg, Object data) {

		RetDataModel retData = new RetDataModel();
		retData.success = success;
		retData.msg = msg;
		retData.data = data;
		String result = JsonHelper.encodeObject2Json(retData, "yyyy-MM-dd HH:mm:ss");
		return result;
	}
}
