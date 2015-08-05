package com.android.volley.ext.sample.transcation;

import org.json.JSONArray;
import com.android.volley.ext.net.BaseJsonArrayTransaction;
import com.android.volley.ext.net.HttpCallback;
import com.android.volley.ext.net.HttpErrorUtil;
import com.android.volley.ext.net.ResponseEntity;
import com.android.volley.ext.sample.Configs;

public class TestJsonArrayTranscation extends BaseJsonArrayTransaction {
	protected String TAG = TestJsonArrayTranscation.class.getSimpleName();
	public TestJsonArrayTranscation(HttpCallback callback) {
		super(callback);
	}

	@Override
	public void prepareRequestOther() {
	}

	@Override
	public String getDevelopUrl() {
		return Configs.API_SERVER_DEVP + Configs.URL.JSONARRAY_URL;
	}

	@Override
	public String getBasicUrl() {
		return Configs.API_SERVER_PRODUCT + Configs.URL.JSONARRAY_URL;
	}

	@Override
	public ResponseEntity parseData(JSONArray jarray) {
		
		ResponseEntity entity = new ResponseEntity();
		int code = HttpErrorUtil.SUCC;
		String msg = "";
		try {
			
			entity.setData(jarray);
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
		return TAG;
	}
}