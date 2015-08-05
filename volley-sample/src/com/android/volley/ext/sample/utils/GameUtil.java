package com.android.volley.ext.sample.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.http.util.EncodingUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.ext.sample.Configs;

public class GameUtil {
	private static final String TAG = "GameUtil";
	
	
	/**
	 * 是否是手机号码账号
	 * @param number
	 * @return
	 */
	public static boolean isPhoneNumber(String number){
		String n = number;
		if(n.contains("@")){
			n = n.substring(0, n.indexOf("@"));
		}
		Pattern pattern = Pattern.compile("^1\\d{10}$");
		Matcher matcher = pattern.matcher(n);
		return matcher.find();
	}
	/**
	 * 删除用户后缀部分
	 * @param user
	 * @return
	 */
	public static String deleteAtSuffix(String user){
		if(user.indexOf("@")>0){
			return user.split("@")[0];
		}else{
			return user;
		}
	}
	
	public static boolean isSogouSuffix(String user){
		if(user.indexOf("@sogou.com")>0){
			return true;
		}
		return false;
	}
	
	public static String deleteSogouSuffix(String userName){
		if(userName.indexOf("@sogou.com")>0){
			return userName.split("@")[0];
		}else{
			return userName;
		}
	}

	public static String getThridUserName(String userName, String provider) {
		if (userName.indexOf("@") > 0) {
			return userName;
		} else {
			return userName = userName + "@" + provider + ".sogou.com";
		}
	}
	
	public static String getBuild(){
		StringBuilder sb = new StringBuilder();
		sb.append("Product Model: ");
		sb.append(android.os.Build.MODEL);
		sb.append(",");
		sb.append(android.os.Build.VERSION.SDK);
		sb.append(",");
		sb.append(android.os.Build.VERSION.RELEASE);		
		Log.i(TAG,"Build:"+sb);
		return sb.toString();
	}
	
	/**
	 * 设备详细信息
	 * @param ctx
	 * @return
	 */
	public static String getDeviceInfo(Context ctx) {

		TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"DeviceId(IMEI)\":\"" + tm.getDeviceId()+"\",");		
		sb.append("\"DeviceSoftwareVersion\":\"" + tm.getDeviceSoftwareVersion()+"\",");
		sb.append("\"Line1Number\":\"" + tm.getLine1Number()+"\",");
		sb.append("\"NetworkCountryIso\":\"" + tm.getNetworkCountryIso()+"\",");
		sb.append("\"NetworkOperator\":\"" + tm.getNetworkOperator()+"\",");
		sb.append("\"NetworkOperatorName\":\"" + tm.getNetworkOperatorName()+"\",");
		sb.append("\"NetworkType\":\"" + tm.getNetworkType()+"\",");
		sb.append("\"PhoneType\":\"" + tm.getPhoneType()+"\",");
		sb.append("\"SimCountryIso\":\"" + tm.getSimCountryIso()+"\",");
		sb.append("\"SimOperator\":\"" + tm.getSimOperator()+"\",");		
		sb.append("\"SimOperatorName\":\"" + tm.getSimOperatorName()+"\",");
		sb.append("\"SimSerialNumber\":\"" + tm.getSimSerialNumber()+"\",");
		sb.append("\"SimState\":\"" + tm.getSimState()+"\",");
		sb.append("\"SubscriberId(IMSI)\":\"" +tm.getSubscriberId()+"\",");
		sb.append("\"VoiceMailNumber\":\"" + tm.getVoiceMailNumber()+"\"");		
		sb.append("}");		
		return sb.toString();
	}	

	/**
	 * 
	 * @param ctx
	 * @return
	 */
	public static String getDeviceId(Context ctx) {
		TelephonyManager tm = (TelephonyManager) ctx
				.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId() == null ? "" : tm.getDeviceId();
	}

	/**
	 * assets下读写文件到sd卡
	 * 
	 * @param context
	 *            上下文环境
	 * @param fileName
	 *            apk名称
	 * @param path
	 *            安装路径
	 * @return
	 */
	public static boolean retrieveFileFromAssets(Context context,
			String fileName, String path) {
		boolean bRet = false;
		try {
			InputStream is = context.getAssets().open(fileName);

			File file = new File(path);
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);

			byte[] temp = new byte[1024];
			int i = 0;
			while ((i = is.read(temp)) > 0) {
				fos.write(temp, 0, i);
			}

			fos.close();
			is.close();

			bRet = true;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return bRet;
	}

	/**
	 * 
	 * @param paramSpannable
	 * @param filter
	 */
	public static String redFontString(String str) {
		return "<font color='#D11301'>" + str + "</font>";
	}

	public static void highlightHotTitle(Spannable paramSpannable, String filter) {
		try {
			Pattern hotPattern = Pattern.compile(filter,
					Pattern.CASE_INSENSITIVE);
			Matcher hotMatcher = hotPattern.matcher(paramSpannable);
			ForegroundColorSpan localForegroundColorSpan3 = new ForegroundColorSpan(
					Color.rgb(255, 0, 0));
			while (hotMatcher.find()) {
				int st = hotMatcher.start();
				int end = hotMatcher.end();
				paramSpannable.setSpan(localForegroundColorSpan3, st, end,
						Spanned.SPAN_POINT_MARK);
			}
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}

	public static boolean isChinese(char c) {

		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;

	}

	/**
	 * 判断是否中文字符
	 * 
	 * @param strName
	 * @return
	 */
	public static Boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		boolean isChinese = false;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c) == true) {
				isChinese = true;
				break;
			}
		}
		return isChinese;
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isUpperCase(String word) {

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param ctx
	 * @param fileName
	 * @return
	 */
	public static String getFromAsset(Context ctx, String fileName) {
		String result = "";
		try {
			// 从Assets中的文件获取输入流
			InputStream in = ctx.getResources().getAssets().open(fileName);

			// 获取文件的字节数
			int length = in.available();

			// 创建byte数组
			byte[] buffer = new byte[length];

			// 将文件中的数据读取到byte数组中
			in.read(buffer);

			// 将byte数组转换成指定格式的字符串
			result = EncodingUtils.getString(buffer, "utf-8");
			if (null != result) {
				result = result.trim();
			}			
		} catch (IOException e) {
			e.printStackTrace(); // 捕获异常并打印
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	private static String sourceId;
	// 获取渠道号
	public static String getSourceId(Context ctx) {
		if(sourceId == null){
			sourceId = getFromAsset(ctx, "sogou_channel");
			
		}		
		return sourceId;
	}

	/**
	 * 
	 * @param ctx
	 * @return
	 * @throws Exception
	 */
	public static String getVersionName(Context ctx) throws Exception {
		// 获取packagemanager的实例
		PackageManager packageManager = ctx.getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = packageManager.getPackageInfo(
				ctx.getPackageName(), 0);
		String version = packInfo.versionName;
		return version;
	}

	/**
	 * 
	 * @param ctx
	 * @return
	 * @throws Exception
	 */
	public static int getVersionCode(Context ctx) throws Exception {
		// 获取packagemanager的实例
		PackageManager packageManager = ctx.getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = packageManager.getPackageInfo(
				ctx.getPackageName(), 0);
		int version = packInfo.versionCode;
		return version;
	}

	/**
	 * 像素转换为dp
	 * @param context
	 * @param pxValue
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
	/**
	 * dp转换为像素
	 * @param context
	 * @param pxValue
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
	
	/**
	 * 计算安装人数
	 * @param value
	 * @return
	 */
	public static String calInstallCount(int value) {

		String suffixString = "人已安装";
		if (value == 0) {
			return "0" + suffixString;
		}
		double div = (double) value / 10000;

		DecimalFormat df = new DecimalFormat("#.#");
		String res = df.format(div);
		if (div >= 1) {
			return res + "万" + suffixString;
		} else {
			return value + suffixString;
		}
	}
	
	
	
	// 生成唯一表示硬件序列号 http://hi.baidu.com/weizi/item/f1d6671030e7e68d88a95638
	public static String getSerialNumber(Context ctx){
		try {
			// androidId 2.2的版本并不是100%可靠
			 String androidId = Secure.getString(ctx.getContentResolver(), Secure.ANDROID_ID);
			 if(androidId == null || "".equals(androidId)){
				 // deviceId也不是100%可靠
				 TelephonyManager tm = (TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE);  
				 String deviceId = tm.getDeviceId();
				 // UUID,但系统清除数据就没有用了
				 if(deviceId == null || "".equals(deviceId)){
					 return MD5.crypt(Installation.id(ctx));
				 }
				 return MD5.crypt(deviceId);			 
			 }
			 return MD5.crypt(androidId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
			 
	}
	/**
	 * 判断是否已经MD5
	 * @param pwd
	 * @return
	 */
	public static boolean isPwdMD5(String pwd){
		if(pwd == null)return false;
		return pwd.length() == 32;
	}
	
	/**
	 * 获取当前设置的电话号码	
	 */
	public static String getNativePhoneNumber(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getLine1Number();
	}
	
	/**
	 * 设置礼包剩余数
	 */
	public static void setRemainsCount(TextView textview,long remains,long totalCount){
		if(remains<10){
			// 需要红色标注 如：剩余 3 个
			SpannableStringBuilder style=new SpannableStringBuilder("剩余"+remains+"个");    
		    style.setSpan(new ForegroundColorSpan(Color.RED),2,3,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);   
		    textview.setText(style);
		    return;
		}
		
		if(remains<20){
			// 当礼包数量小于20个时，则显示剩余个数 如：剩余19 个
			textview.setText("剩余"+remains+"个");
			return;
		}
		
		if(remains>20){
			// 当礼包数量大于20个时，显示剩余百分比  如：剩余19%
			NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
	        format.setMinimumFractionDigits(0);// 设置小数位	       
			textview.setText("剩余"+format.format((float)remains/(float)totalCount));
			return;
		}
	}
	
	/**
	 * 设置礼包内容简介
	 * @param textView
	 * @param conent
	 */
	public static void setGiftContent(TextView textView,String conent){
		textView.setText(replaceBlank(conent));
	}
	
	/**
	 * 去掉空格回车制表字符
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}
	
	/**
	 * 设置礼包操作按钮文字
	 * @param button
	 * @param open
	 */
	public static void setOpGiftButton(Button button,String open ){
		if("true".equals(open)){
			button.setText("领取");
		}else{
			button.setText("下架");
			button.setClickable(false);
		}
	}
	
	
	
	
	
	public static boolean checkPkgName(Context context,String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(
                    packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
	/**
	 * 转换成2012年12月12日格式
	 * @param time
	 * @return
	 */
	public static String formatDate(long time){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
		return format.format(new Date(time));
	}
	
	public static final String GMALL_CRASH_INFO = "gmall_crash_info";
	/**
	 * 保存奔溃日志
	 * @param context
	 * @param error
	 */
	public static void saveCrashInfo(Context context,String error){
		SharedPreferences pref = context.getSharedPreferences(GMALL_CRASH_INFO, Context.MODE_PRIVATE);
		String content = pref.getString("error", "")+error;
		SharedPreferences.Editor  editor = pref.edit();		
		editor.putString("error", content);
		boolean is = editor.commit();		
		Log.d(TAG,"saveCrashInfo:"+content);
	}
	
	public static void deleteCrashInfo(Context context){
		SharedPreferences pref = context.getSharedPreferences(GMALL_CRASH_INFO, Context.MODE_PRIVATE);
		SharedPreferences.Editor  editor = pref.edit();
		editor.remove("error");		
		boolean is = editor.commit();	
	}
	
	public static String getCrashInfo(Context context){
		SharedPreferences pref = context.getSharedPreferences(GMALL_CRASH_INFO, Context.MODE_PRIVATE);
		String content = pref.getString("error", "");
		return content;
	}
	
	
	public static String formetFileSize(long fileS) {//转换文件大小
        DecimalFormat df = new DecimalFormat("#");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }
	
}
