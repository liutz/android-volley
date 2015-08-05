package com.android.volley.ext.sample.type;

import android.util.Log;
import com.android.volley.ext.sample.transcation.TestJsonArrayNotRevalidateTranscation;
import com.android.volley.ext.sample.transcation.TestJsonArrayTranscation;
import com.android.volley.ext.net.HttpCallback;
public class JSONArrayType {
		private static final String TAG = "JSONArrayType";
		// JSON数组GET请求，带Callback，默认开启缓存，默认不检查
		public static void testGetJsonArray(){
			new TestJsonArrayTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJsonArray onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJsonArray onFailure:"+msg);				
				}
				
			}).get();
		}		
		
		public static void testGetJsonArrayNotRevalidate(){
			TestJsonArrayNotRevalidateTranscation tjanr = new TestJsonArrayNotRevalidateTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"TestJsonArrayNotRevalidateTranscation onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"TestJsonArrayNotRevalidateTranscation onFailure:"+msg);				
				}
				
			});			
			tjanr.get();			
		}
		
		// JSON数组GET请求，带Callback，关闭缓存，默认不检查 【通过】
		public static void testGetCloseCacheJsonArray(){
			TestJsonArrayTranscation tjat = new TestJsonArrayTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJsonArray onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJsonArray onFailure:"+msg);				
				}
				
			});
			tjat.setShouldCache(false);
			tjat.get();
		}
		
		// JSON数组GET请求，带Callback，开启检查，默认开启缓存
		public static void testGetForceCacheJsonArray(){
			TestJsonArrayTranscation tjat = new TestJsonArrayTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetJsonArray onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetJsonArray onFailure:"+msg);				
				}
				
			});
			tjat.setForceCache(true);
			tjat.get();
		}
		
		// JSON数组POST请求（关闭缓存），带Callback
		public static void testPostJsonArray(){
			new TestJsonArrayTranscation(new HttpCallback(){

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
