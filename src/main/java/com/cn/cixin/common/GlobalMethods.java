package com.cn.cixin.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public final class GlobalMethods {

	private GlobalMethods() {
	}
	/**
	 * ����ѯ����������
	 * @param return_code
	 * @param data
	 * @return
	 */
	public static JSONObject ReturnJSONObject(int return_code,JSONObject data) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("return_code", return_code);
		jsonObject.put("data", data);
		return jsonObject;
	}
	public static JSONObject ReturnJSONOArray(int return_code,JSONArray data) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error_code", return_code);
		jsonObject.put("data", data);
		jsonObject.put("count", data.size());
		return jsonObject;
	}
}
