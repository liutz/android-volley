package com.android.volley.ext.net;

import java.util.HashMap;
import org.json.JSONArray;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Request.Method;
import com.android.volley.ext.GameVolley;
/**
 * JSON数组请求基类
 */
public abstract class BaseJsonArrayTransaction extends BaseTranscation {	
	protected String TAG = BaseJsonArrayTransaction.class.getSimpleName();
	private JSONArrayRequest jsonArrayRequest = null;
	
	public JSONArrayRequest getJsonArrayRequest() {
		return jsonArrayRequest;
	}
	
	public BaseJsonArrayTransaction(HttpCallback callback) {
		super();
		this.callback = callback;		
		mQueue = GameVolley.getRequestQueue();
	}
	
	/**
	 * 执行请求动作
	 */
	public Request<JSONArray> process(int method) {
		configDevMode();
		prepareRequest();
		if(method == Method.GET){
			url = getUrlWithQueryString(url);
		}		
		try {					
			jsonArrayRequest = new JSONArrayRequest(method, url, params, responseListener, errorListener);
			jsonArrayRequest.setShouldCache(shouldCache);
			if(Method.POST == method){
				jsonArrayRequest.setShouldCache(false);
			}
			jsonArrayRequest.setForceCache(forceCache);
			mQueue.add(jsonArrayRequest);
			return jsonArrayRequest;
		} catch (Exception e) {
			e.printStackTrace();
			if (callback != null) {
				callback.onFailure(HttpErrorUtil.ERROR_PREPARE_REQUEST_EXCEPTION, e.getMessage(), null);
			}
		}
		return jsonArrayRequest;
	}
	
	/**
	 * 请求结果回调通知
	 */
	private Response.Listener<JSONArray> responseListener = new Response.Listener<JSONArray>() {

		@Override
		public void onResponse(JSONArray response) {			
			ResponseEntity entity = parseData(response);
			if (entity != null && null != callback){
				int code = entity.getCode();
				if (code == HttpErrorUtil.SUCC){
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
	
	public abstract String getTag();

	/**
	 * 解析JSON数组
	 * @param content
	 * @return
	 */
	public abstract ResponseEntity parseData(JSONArray content);
	
	public void get(){
		this.process(Method.GET);
	}
	
	public void post(){
		this.process(Method.POST);
	}
}
