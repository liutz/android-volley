package com.android.volley.ext.net;

import java.util.HashMap;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.ext.GameVolley;
import com.android.volley.Response;
/**
 * JSON对象请求基类
 */
public abstract class BaseJsonTransaction extends BaseTranscation{
	
	public BaseJsonTransaction(HttpCallback callback) {
		super();
		this.callback = callback;
		TAG = getClass().getName();
		mQueue = GameVolley.getRequestQueue();
	}
	
	private JSONObjectRequest jsonObjectRequest = null;
	
	public String getUrl() {
		if(jsonObjectRequest != null){			
			return jsonObjectRequest.getUrl();
		}
		return null;
	}
	
	/**
	 * 执行请求动作
	 */
	public Request<JSONObject> process(int method) {
		configDevMode();
		prepareRequest();		
		if(method == Method.GET){
			url = getUrlWithQueryString(url);
		}		
		try {
			jsonObjectRequest = new JSONObjectRequest(method, url, params, responseListener, errorListener);			
			jsonObjectRequest.setShouldCache(shouldCache);
			if(Method.POST == method){
				jsonObjectRequest.setShouldCache(false);
			}
			jsonObjectRequest.setForceCache(forceCache);
			mQueue.add(jsonObjectRequest);
		} catch (Exception e) {
			e.printStackTrace();			
			if (callback != null) {
				callback.onFailure(HttpErrorUtil.ERROR_PREPARE_REQUEST_EXCEPTION, e.getMessage(), null);
			}
		}
		return jsonObjectRequest; 
	}

	/**
	 * 请求结果回调通知
	 */
	private  Response.Listener<JSONObject> responseListener =   new Response.Listener<JSONObject>()  {

		@Override
		public void onResponse(JSONObject response) {						
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
	
	/**
	 * 请求准备相关参数
	 */
	public void prepareRequest() {
		initParams();
		prepareRequestOther();
	}

	private void initParams() {
		params = new HashMap<String, String>();
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
	 * 解析JSON对象
	 * @param content
	 * @return
	 */
	public abstract ResponseEntity parseData(JSONObject content);
	
	public abstract String getTag();
	
	public void get(){
		this.process(Method.GET);
	}
	public void post(){
		this.process(Method.POST);
	}

}
