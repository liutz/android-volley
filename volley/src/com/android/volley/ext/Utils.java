package com.android.volley.ext;

import java.io.File;
import android.os.Environment;
import android.os.StatFs;

public class Utils {
	// sd卡是否可用
	public static boolean sdCardAvailable() {
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			return true;
		}		
		return false;
	}
	
	// 获取sd剩余空间
	public static long getSDFreeSize(){
		//取得SD卡文件路径
		File path = Environment.getExternalStorageDirectory(); 
		StatFs sf = new StatFs(path.getPath()); 
		//获取单个数据块的大小(Byte)
		long blockSize = sf.getBlockSize(); 
		//空闲的数据块的数量
		long freeBlocks = sf.getAvailableBlocks();
		//返回SD卡空闲大小
		return (freeBlocks * blockSize); //单位MB
	  }
}
