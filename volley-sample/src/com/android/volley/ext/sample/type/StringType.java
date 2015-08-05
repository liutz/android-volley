package com.android.volley.ext.sample.type;

import android.util.Log;
import com.android.volley.ext.sample.transcation.TestStringNotRevalidateTranscation;
import com.android.volley.ext.sample.transcation.TestStringTranscation;
import com.android.volley.ext.net.HttpCallback;

public class StringType {
		private static final String TAG = "StringType";
		// 字符串GET请求，带Callback，默认开启缓存，默认不检查
		public static void testGetString(){
			new TestStringTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetString onSuccess:"+data);
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetString onFailure:"+msg);				
				}
				
			}).get();
		}
		
		// 字符串GET请求，带Callback，开启缓存
		public static void testGetStringNotRevalidate(){
			TestStringNotRevalidateTranscation tsnrt = new TestStringNotRevalidateTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetStringNotRevalidate onSuccess:"+data);
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetStringNotRevalidate onFailure:"+msg);				
				}
				
			});	
			tsnrt.setForceCache(true);
			tsnrt.get();
		}
		
		// 字符串GET请求，带Callback，关闭缓存，默认不检查
		public static void testGetCloseCacheString(){
			TestStringTranscation tjat = new TestStringTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetCloseCacheString onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetCloseCacheString onFailure:"+msg);				
				}
				
			});
			tjat.setShouldCache(false);
			tjat.get();
		}
		
		// 字符串GET请求，带Callback，开启检查，默认开启缓存
		public static void testGetForceCacheString(){
			TestStringTranscation tjat = new TestStringTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testGetOpenCheckString onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testGetOpenCheckString onFailure:"+msg);				
				}
				
			});
			tjat.setForceCache(true);
			tjat.get();
		}
		
		// 字符串POST请求（关闭缓存），带Callback
		public static void testPostString(){
			new TestStringTranscation(new HttpCallback(){

				@Override
				public void onSuccess(int code, String msg, Object data) {
					Log.d(TAG,"testPostString onSuccess:"+data);				
				}

				@Override
				public void onFailure(int code, String msg, Object data) {
					Log.e(TAG,"testPostString onFailure:"+msg);				
				}
				
			}).post();
		}

}
