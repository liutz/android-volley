package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.ext.Utils;

import java.io.File;

public class Volley {

    /** Default on-disk cache directory. */
    private static final String DEFAULT_CACHE_DIR = "volley";
    // 用户设置sdcard缓存路径以下划线结尾
    public static String SET_ROOT_CACHE_DIR;
    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @param stack An {@link HttpStack} to use for the network, or null for default.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context, HttpStack stack) {
    	File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
    	// 判断当前SD卡是否可用，大小大于15M    	
    	if(SET_ROOT_CACHE_DIR != null && Utils.sdCardAvailable() && Utils.getSDFreeSize() >= 15728640){
    		try{
    			File f = new File(Environment.getExternalStorageDirectory().toString(),SET_ROOT_CACHE_DIR);
        		if(!f.exists()){
        			f.mkdirs();        			
        		}
        		cacheDir = f;
    		}catch (Exception e){
    			e.printStackTrace();
    		}    		
    	}
        String userAgent = "volley/0";
        try {
            String packageName = context.getPackageName();
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            userAgent = packageName + "/" + info.versionCode;
        } catch (NameNotFoundException e) {
        }

        if (stack == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                stack = new HurlStack();
            } else {
                // Prior to Gingerbread, HttpUrlConnection was unreliable.
                // See: http://android-developers.blogspot.com/2011/09/androids-http-clients.html
                stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
            }
        }

        Network network = new BasicNetwork(stack);

        RequestQueue queue = new RequestQueue(new DiskBasedCache(cacheDir), network);
        queue.start();

        return queue;
    }

    /**
     * Creates a default instance of the worker pool and calls {@link RequestQueue#start()} on it.
     *
     * @param context A {@link Context} to use for creating the cache dir.
     * @return A started {@link RequestQueue} instance.
     */
    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
