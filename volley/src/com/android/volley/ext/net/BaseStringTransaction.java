package com.android.volley.ext.net;

import java.util.HashMap;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.ext.GameVolley;
import com.android.volley.Response;
/**
 * String对象请求基类
 */
public abstract class BaseStringTransaction extends BaseTranscation{
	
	private StringRequest stringRequest = null;
	
	public StringRequest getStringRequest(){
		return stringRequest;
	}
	
	public BaseStringTransaction(HttpCallback callback) {
		super();
		this.callback = callback;
		mQueue = GameVolley.getRequestQueue();
	}
	
	public Request<String> process(int method) {
		configDevMode();
		prepareRequest();		
		if(method == Method.GET){
			url = getUrlWithQueryString(url);
		}		
		try {
			stringRequest = new StringRequest(method, url, params,responseListener, errorListener);
			if(headers != null){
				stringRequest.setHeaders(headers);
			}
			stringRequest.setShouldCache(shouldCache);
			if(Method.POST == method){
				stringRequest.setShouldCache(false);
			}
			stringRequest.setForceCache(forceCache);
			mQueue.add(stringRequest);
		} catch (Exception e) {
			e.printStackTrace();			
			if (callback != null) {
				callback.onFailure(HttpErrorUtil.ERROR_PREPARE_REQUEST_EXCEPTION, e.getMessage(), null);
			}
		}
		return stringRequest;	
	}

	/**
	 * 
	 */
	private  Response.Listener<String> responseListener =   new Response.Listener<String>()  {

		@Override
		public void onResponse(String response) {			
			ResponseEntity entity = parseData(response);			
			if (entity != null && null != callback){
				int code = entity.getCode();
				if (code ==  HttpErrorUtil.SUCC){
					callback.onSuccess(entity.getCode(), entity.getMsg(), entity.getData());	
				}else{
					callback.onFailure(entity.getCode(), entity.getMsg(), entity.getData());
				}	
			}
		}
	};
	
	public void prepareRequest() {
		initParams();
		prepareRequestOther();
	}

	private void initParams() {
		params = new HashMap<String, String>();
	}
	
	protected void setHeader(String key, String value) {
		if(headers == null){
			headers = new HashMap<String, String>();
		}
		headers.put(key, value);
	}
	
	protected void setParam(String key, String value) {

		if (params == null) {
			initParams();

		}
		params.put(key, value);

	}

	protected void removeParam(String param) {
		params.remove(param);
	}

	public abstract void prepareRequestOther();	

	/**
	 * 解析String对象
	 * @param content
	 * @return
	 */
	public abstract ResponseEntity parseData(String content);
	
	public abstract String getTag();
	
	public void get(){
		this.process(Method.GET);
	}
	public void post(){
		this.process(Method.POST);
	}
}
