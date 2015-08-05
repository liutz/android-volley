package com.android.volley.ext.net;

public interface HttpCallback {
	
	/*
	 * HTTP request succ callback
	 */
	public void onSuccess(int code, String msg, Object data);
	/*
	 * HTTP request fail callback
	 */
	public void onFailure(int code, String msg, Object data);
}
