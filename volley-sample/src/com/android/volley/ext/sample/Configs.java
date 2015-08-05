package com.android.volley.ext.sample;

public class Configs {
	// 开发环境
	//public static final String API_SERVER_DEVP = "http://dev.g.sogou.com";
	public static final String API_SERVER_DEVP = "http://dev.g.sogou.com";
	// 线上环境
	public static final String API_SERVER_PRODUCT = "http://g.sogou.com";
	// 数据DC
	public static final String API_PINGBACK_SERVER = "http://pb.sogou.com/pv.gif";
	
	// 配置接口URL
	public static class URL{
		// 推荐位数据
		public static final String RECOMMEND = "/recommend/100000.json";
		// 游戏详情 格式/game/${gid}.json
		public static String GAME_DETAIL = "/game/${gid}.json";
		// 测试缓存json对象
		public static String JSON_URL = "/cacheTest/object.do";		
		public static String JSON_NOT_REVALIDATE_URL = "/cacheTest/object-not-revalidate.do";		
		// 测试缓存json数组
		public static String JSONARRAY_URL = "/cacheTest/array.do";
		public static String JSONARRAY_NOT_REVALIDATE_URL = "/cacheTest/array-not-revalidate.do";
		// 测试缓存字符串
		public static String STRING_URL = "/cacheTest/string.do";
		public static String STRING_NOT_REVALIDATE_URL = "/cacheTest/string-not-revalidate.do";
		
	}
	
	// 配置字段
	public static class Keys {
		public static final String GID = "100000";
		public static final String APPKEY = "c1c6dfeba45b161692d66d531ac8d85e096bae4de1fe69d9aea57525e5afa1d4";
		public static final String SOURCE_ID = "source";
		public static final String ERROR = "error";
		public static final String RESULT = "result";
		public static final String CODE = "code";
		public static final String MESSAGE = "message";
		public static final String SHOULD_UPDATE = "should_update";
		public static final String IS_FORCE_UPDATE = "is_force_update";
		public static final String DOWNLOAD_ULR = "download_url";
		public static final String UPDATE_INFO = "update_info";
		public static final String NAME = "name";
		public static final String CATE_ID = "cateId";
		public static final String COUNT = "count";
		public static final String IMG = "img";
		public static final String GID_NAME = "gid";
		public static final String SOURCE = "source";
		public static final String RECOMMEND="recommend";
		public static final String API_TOKEN = "api_token";
		public static final String GUESS = "guess";
		public static final String SCREENSHOTS = "screenshots";
		public static final String GAME = "game";
		public static final String ICON = "icon";
		public static final String CATEGORY = "category";
		public static final String DESC = "desc";
		public static final String TAG = "tag";
		public static final String STARS = "stars";
		public static final String DOWNLOAD_URL = "downloadUrl";
		public static final String DOWNLOAD_TIMES = "downloadTimes";
		public static final String SIZE = "size";
		public static final String NEED_UPDATE="needUpdate";
		public static final String PACKAGE_NAME="package";
		public static final String VERSION_NAME = "version_name";
		public static final String VERSIONNAME = "versionName";
		public static final String VERSION_CODE = "version_code";
		public static final String VERSIONCODE = "versionCode";
		
		public static final String UPDATE_TIME = "updateTime";
		public static final String LINK = "link";
		public static final String VERSION = "version";
		public static final String DEVELOPER = "developer";
		
		public static final String REMAINS = "remains";
		public static final String GAMES = "games";
		public static final String ID = "id";
		
		public static final String TYPE = "type";
		public static final String URL = "url";
		
		public static final String ZT = "zt";
		public static final String APP_POOL = "appPool";
		public static final String APP = "app";
		
		public static final String PACKAGES="pkgs";
		public static final String DATA="data";		
		
		public static final String CONTENT="content";
		public static final String CONTACT="contact";
		public static final String TITLE="title";
		public static final String DATE="date";
		public static final String NEWS="news";
		public static final String SEARCH_LIST = "searchList";
		public static final String CLOUD_TAG_WEIGHT = "weight";
		
		public static final String USER_NAME = "username";
		public static final String PASSWORD = "password";
		public static final String UIDI = "udid"; //设备号
		public static final String USER_ID = "user_id";
		public static final String SESSION_KEY = "session_key";
		public static final String BIND_UID = "bind_uid";
		public static final String CAPTCHA = "captcha";
		public static final String CID = "cid";
		public static final String CLIENTID = "clientid";
		public static final String EXTRAS = "extras";
		public static final String CAPTCHA_ID = "captcha_id";
		public static final String MOBILE = "mobile"; //设备号
		
		public static final String THRID_3RD = "3rd";
		public static final String THIRD_QQ = "qq";
		public static final String THRID_SINA = "sina";
		public static final String UID = "uid";
		public static final String SID = "sid";
		public static final String TOKEN = "token";	
		public static final String EMAIL = "email";
		public static final String GIFT = "gift";
		public static final String TIME = "time";
	}	

}
