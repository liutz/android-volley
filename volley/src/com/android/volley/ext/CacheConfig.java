package com.android.volley.ext;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;

public class CacheConfig{
	// 图片缓存路径
	public String imagePath;
	// 图片缓存大小
	public int imageSize;
	// 图片缓存压缩格式
	public CompressFormat imageCompressFormat;
	// 图片压缩品质
	public int imageQuality;
	// 列表数据缓存路径
	public String cacheDir;
	// 列表数据缓存大小
	public int size;
	public CacheConfig(Context context){
		imagePath = context.getPackageCodePath();
		imageSize = 10485760;
		imageCompressFormat = CompressFormat.PNG;
		imageQuality = 100;
	}
}
