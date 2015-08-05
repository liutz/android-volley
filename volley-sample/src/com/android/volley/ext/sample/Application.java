package com.android.volley.ext.sample;

import com.android.volley.ext.CacheConfig;
import com.android.volley.ext.GameVolley;

public class Application extends android.app.Application {

	@Override
	public void onCreate() {		
		super.onCreate();
		
		CacheConfig config = new CacheConfig(getApplicationContext());
		config.cacheDir = "Sogou/Sogou-volley/Cache/data";
		config.imageSize = 50*1025*1025;
		config.size = 10*1024*1024;
		config.imagePath = "Sogou/Sogou-volley/Cache/image";
		GameVolley.isDebugMode = true;
		GameVolley.init(getApplicationContext(),config);
	}	
}
