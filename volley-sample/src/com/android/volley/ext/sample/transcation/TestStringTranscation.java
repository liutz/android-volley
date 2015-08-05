package com.android.volley.ext.sample.transcation;

import com.android.volley.ext.net.BaseStringTransaction;
import com.android.volley.ext.net.HttpCallback;
import com.android.volley.ext.net.HttpErrorUtil;
import com.android.volley.ext.net.ResponseEntity;
import com.android.volley.ext.sample.Configs;
import android.util.Log;

public class TestStringTranscation extends BaseStringTransaction {	

	private static final String TAG = "TestStringTranscation";
	public TestStringTranscation(HttpCallback callback) {
		super(callback);		
	}
	

	@Override
	public String getDevelopUrl() {
		return Configs.API_SERVER_DEVP +Configs.URL.STRING_URL;
	}

	@Override
	public String getBasicUrl() {
		return Configs.API_SERVER_PRODUCT +Configs.URL.STRING_URL;
	}

	@Override
	public void prepareRequestOther() {			
		
	}

	@Override
	public ResponseEntity parseData(String content) {
		Log.d(TAG,"parseData:"+content);
		ResponseEntity entity = new ResponseEntity();
		int code = HttpErrorUtil.SUCC;		
		entity.setCode(code);
		entity.setData(content);
		entity.setMsg(content);
		return entity;
	}
	@Override
	public String getTag() {
		return "TestStringTranscation";
	}
}
