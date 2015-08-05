package com.android.volley.ext;

import java.io.File;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.ext.cache.ImageCacheManager;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.Volley;

public class GameVolley {
    // 配置开发模式，默认是线上环境
	public static boolean isDebugMode = false;
    private static RequestQueue mRequestQueue;
    private GameVolley() {}
    
    public static void openLogInfo(){
    	VolleyLog.DEBUG = true;
    }
    
    // 程序入口初始化一次
    public static void init(Context context) {
    	if(mRequestQueue == null){
    		mRequestQueue = Volley.newRequestQueue(context);
    		CacheConfig cc = new CacheConfig(context);
    		ImageCacheManager.getInstance().init(context
            		, null
    				, cc.imageSize
    				, cc.imageCompressFormat
    				, cc.imageQuality);
    	}        
    }
    // 获取图片缓存
    public static Bitmap getImageCache(String url){
    	return ImageCacheManager.getInstance().getImageBitmap(url);
    }
    
    // 获取数据缓存 
    public static byte[] getDataCache(String url){
    	if(mRequestQueue != null){
    		Cache.Entry entry = mRequestQueue.getCache().get(url);
    		if(entry != null && entry.data != null){
				return entry.data;
			}    		
    	}
    	return null;
    }
    
    
    // 获取图片并缓存
    public static void getImage(String url,final ImageListener listener){
    	ImageCacheManager.getInstance().getImageCallback(url, new com.android.volley.toolbox.ImageLoader.ImageListener(){

			@Override
			public void onErrorResponse(VolleyError error) {
				if(listener != null)
					listener.onError();
			}

			@Override
			public void onResponse(ImageContainer response, boolean isImmediate) {
				if(listener != null)
					listener.onSuccess(isImmediate);				
			}			
		});		
    }
    
    // 程序入口初始化一次
    public static void init(Context context,CacheConfig config) {
    	if(mRequestQueue == null){
    		// 设置缓存路径
    		Volley.SET_ROOT_CACHE_DIR = config.cacheDir;
    		if(config.size > 0){
    			DiskBasedCache.DEFAULT_DISK_USAGE_BYTES = config.size;
    		} 
    		mRequestQueue = Volley.newRequestQueue(context);
    		CacheConfig cc = new CacheConfig(context);  		
    		// 图片路径    		
    		if(config.imagePath != null && Utils.sdCardAvailable() && Utils.getSDFreeSize()>=cc.imageSize+5242880){
        		try{
        			File f = new File(Environment.getExternalStorageDirectory().toString(),config.imagePath);
            		if(!f.exists()){
            			f.mkdirs();            			
            		}
            		config.imagePath = f.getAbsolutePath();
        		}catch (Exception e){
        			e.printStackTrace();
        		}    		
        	}else{
        		// SD卡不可用情况，图片缓存放到data区域
        		config.imagePath = null;
        	}
    		ImageCacheManager.getInstance().init(context
            		, config.imagePath == null ? null:config.imagePath
    				, config.imageSize == 0 ? cc.imageSize:config.imageSize
    				, config.imageCompressFormat == null ? cc.imageCompressFormat:config.imageCompressFormat
    				, config.imageQuality == 0 ? cc.imageQuality : config.imageQuality);
    	}        
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }    
    
    public static void cancel(Context context){
    	if(mRequestQueue!= null){
    		mRequestQueue.cancelAll(context);    		
		}
	}
}
