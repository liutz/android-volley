package com.android.volley.ext.sample;


import com.android.volley.ext.sample.type.JSONArrayType;
import com.android.volley.ext.sample.type.JSONType;
import com.android.volley.ext.sample.type.StringType;
import com.android.volley.toolbox.NetworkImageView;
import com.sogou.game.common.test.R;
import android.app.Activity;
import android.os.Bundle;
/**
 * must-revalidate或proxy-revalidate 告诉客户端，下次请求必须先到服务器
 * 如果是304继续使用资源，如果网络不好情况下，导致客户端体验非常不好
 * UI无法显示，所以可以通过ForceCache优先走缓存，再校验资源是否有效策略
 */
public class Main extends Activity {
	private static final String TAG = "liutz";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.main);
		
		//图片缓存测试
		NetworkImageView niv = (NetworkImageView) findViewById(R.id.myImg);
		niv.setImageUrl("http://s0.wan.sogou.com/cdn/image/2014/03/11/20140311161453_165.jpg", R.drawable.default_banner_icon);
		
		//JSONArrayType.testGetJsonArray(); // 优先走网络，查看资源是否有效
		//JSONArrayType.testGetForceCacheJsonArray(); // 不管是否过期，优先走缓存，再检查网络资源是否有效
		//JSONArrayType.testGetJsonArrayNotRevalidate(); // 只要没有过期，都走缓存
		//JSONArrayType.testGetCloseCacheJsonArray(); // 每次走网络，避免脏数据
		JSONArrayType.testPostJsonArray(); // POST每次走网络		
		
		//JSONType.testGetJson(); 
		//JSONType.testGetForceCacheJson(); 
		//JSONType.testGetJsonNotRevalidate(); 
		//JSONType.testGetCloseCacheJson(); 
		//JSONType.testPostJson(); 		
		
		//StringType.testGetString();
		//StringType.testGetForceCacheString();
		//StringType.testGetStringNotRevalidate();
		//StringType.testGetCloseCacheString();
		//StringType.testPostString();
		
		
	}	
}
