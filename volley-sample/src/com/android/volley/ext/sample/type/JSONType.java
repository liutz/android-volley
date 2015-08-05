package com.android.volley.ext.sample.type;

import android.util.Log;
import com.android.volley.ext.sample.transcation.TestJsonNotRevalidateTranscation;
import com.android.volley.ext.sample.transcation.TestJsonTranscation;
import com.android.volley.ext.net.HttpCallback;

public class JSONType {
		private static final String TAG = "JSONType";
		// JSON数组GET请求，带Callback，默认开启缓存，默认不检查
		public static void testGetJson(){
			new TestJsonTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJson onSuccess:"+data);
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJson onFailure:"+msg);				
				}
				
			}).get();
		}
		
		// JSON数组GET请求，带Callback，默认开启缓存，强制走cache
		public static void testGetForceCacheJson(){
			TestJsonTranscation tjt = new TestJsonTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJson onSuccess:"+data);
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJson onFailure:"+msg);				
				}
				
			});
			tjt.setForceCache(true);
			tjt.get();
		}
		
		// JSON数组GET请求，带Callback，默认开启缓存，默认不强制走cache
		public static void testGetJsonNotRevalidate(){
			new TestJsonNotRevalidateTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJsonNotRevalidate onSuccess:"+data);
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJsonNotRevalidate onFailure:"+msg);				
				}
				
			}).get();
		}
		
		// JSON数组GET请求，带Callback，关闭缓存，默认不强制走cache【全新请求，避免脏数据】
		public static void testGetCloseCacheJson(){
			TestJsonTranscation tjat = new TestJsonTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJson onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJson onFailure:"+msg);				
				}
				
			});
			tjat.setShouldCache(false);
			tjat.get();
		}		
		
		// JSON数组POST请求（关闭缓存），带Callback
		public static void testPostJson(){
			new TestJsonTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testPostJsonArray onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testPostJsonArray onFailure:"+msg);				
				}
				
			}).post();
		}

}
