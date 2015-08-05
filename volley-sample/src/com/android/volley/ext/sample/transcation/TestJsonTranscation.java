package com.android.volley.ext.sample.transcation;

import org.json.JSONObject;

import com.android.volley.ext.net.BaseJsonTransaction;
import com.android.volley.ext.net.HttpCallback;
import com.android.volley.ext.net.HttpErrorUtil;
import com.android.volley.ext.net.ResponseEntity;
import com.android.volley.ext.sample.Configs;

public class TestJsonTranscation extends BaseJsonTransaction {
	
	public TestJsonTranscation(HttpCallback callback) {
		super(callback);	
	}

	@Override
	public void prepareRequestOther() {
		setShouldCache(false);
	}

	@Override
	public String getDevelopUrl() {		
		return Configs.API_SERVER_DEVP + Configs.URL.JSON_URL;
	}

	@Override
	public String getBasicUrl() {		
		return Configs.API_SERVER_PRODUCT + Configs.URL.JSON_URL;
	}

	@Override
	public ResponseEntity parseData(JSONObject obj) {
		
		ResponseEntity entity = new ResponseEntity();
		int code = HttpErrorUtil.SUCC;
		String msg = "";
		try {			
			if (null != obj) {
				entity.setData(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity.setCode(HttpErrorUtil.ERROR_PARSE_DATA_EXCEPTION);
			entity.setMsg(HttpErrorUtil.getErrorMsg(HttpErrorUtil.ERROR_PARSE_DATA_EXCEPTION));
			return entity;
		}
		entity.setCode(code);
		entity.setMsg(msg);
		return entity;
	}

	@Override
	public String getTag() {
		return "TestJsonTranscation";
	}
}