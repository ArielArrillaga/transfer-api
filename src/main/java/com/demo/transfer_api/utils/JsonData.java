package com.demo.transfer_api.utils;

import org.json.JSONObject;

public class JsonData {
	
	public static JSONObject getJsonObject(JSONObject jsonObject, String key) throws Exception {
		if (jsonObject.has(key)) {
		   return jsonObject.optJSONObject(key);
		}
		throw new Exception();
	}
	
	public static String getValueFromJsonObject(JSONObject jsonObject, String key){
		if (jsonObject.has(key)) {
		   return jsonObject.optString(key);
		}
		return "";
	}
}
