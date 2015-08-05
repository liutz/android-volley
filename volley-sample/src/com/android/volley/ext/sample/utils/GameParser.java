package com.android.volley.ext.sample.utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.ext.sample.Configs;
import com.android.volley.ext.sample.entity.Game;
import com.android.volley.ext.sample.entity.News;
import com.android.volley.ext.sample.entity.NewsIndex;
import com.android.volley.ext.sample.entity.Subject;
import com.android.volley.ext.sample.entity.SubjectContent;
/**
 *	游戏实体解析类
 */
public class GameParser {	
	
	public static List<Subject> parseSubjects(JSONArray array) throws JSONException {
		
		if (null != array && array.length() > 0) {
			List<Subject> subjects = new ArrayList<Subject>();

			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				subjects.add(parseSubject(obj));
			}
			return subjects;
		} else {
			return null;
		}
	}
	
	public static Subject parseSubject(JSONObject jb) throws JSONException {

		String id = "";
		String name = "";
		String img = "";

		// 获取类别属性
		if (!jb.isNull(Configs.Keys.NAME)) {
			name = jb.getString(Configs.Keys.NAME);
		}
		if (!jb.isNull(Configs.Keys.ID)) {
			id = jb.getString(Configs.Keys.ID);
		}

		if (!jb.isNull(Configs.Keys.IMG)) {
			img = jb.getString(Configs.Keys.IMG);
		}
		Subject subject = new Subject(id, name, img);
		return subject;
	}
	
	public static SubjectContent parseSubjectContent(JSONObject obj) throws JSONException {

		SubjectContent sc = new SubjectContent();
		if (!obj.isNull(Configs.Keys.GAMES)) {
			JSONArray ja = obj.getJSONArray(Configs.Keys.GAMES);
			List<Game> games = GameParser.parseGame(ja);
			sc.setGames(games);
		}
		if (!obj.isNull(Configs.Keys.ID)) {
			String id = obj.getString(Configs.Keys.ID);
			sc.setId(id);
		}
		if (!obj.isNull(Configs.Keys.ICON)) {
			String icon = obj.getString(Configs.Keys.ICON);
			sc.setIcon(icon);
		}
		if (!obj.isNull(Configs.Keys.NAME)) {
			String name = obj.getString(Configs.Keys.NAME);
			sc.setName(name);
		}
		return sc;
	}

	/**
	 * 解析静态游戏列表
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	public static List<Game> parseApps(JSONArray array) throws JSONException {

		if (null != array && array.length() > 0) {
			List<Game> apps = new ArrayList<Game>();

			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				apps.add(parseApp(obj));
			}
			return apps;
		} else {
			return null;
		}

	}
	
	public static List<List<Game>> parseAppPool(JSONArray array) throws JSONException{
		List<List<Game>> appPool = new ArrayList<List<Game>>();
		if(null != array && array.length() >0){
			for(int i =0;i<array.length();i++){
				JSONArray obj = array.getJSONArray(i);				
				appPool.add(parseApps(obj));
			}
			//return appPool;
		}
		return appPool;
	}
	
	public static Game parseApp(JSONObject obj) throws JSONException {

		Game app = new Game();
		// 获取类别属性
		if (!obj.isNull(Configs.Keys.ICON)) {
			app.setIcon(obj.getString(Configs.Keys.ICON));
		}
		// 获取包名
		if (!obj.isNull(Configs.Keys.PACKAGE_NAME)) {
			app.setPackageName(obj.getString(Configs.Keys.PACKAGE_NAME));
		}
		// 获取版本号
		if (!obj.isNull(Configs.Keys.VERSIONCODE)) {
			app.setVersionCode(obj.getString(Configs.Keys.VERSIONCODE));
		}
		// 获取推荐语
		if (!obj.isNull(Configs.Keys.RECOMMEND)) {
			app.setRecommend(obj.getString(Configs.Keys.RECOMMEND));
		}
		
		if (!obj.isNull(Configs.Keys.DESC)) {
			app.setDesc(obj.getString(Configs.Keys.DESC));
		}

		if (!obj.isNull(Configs.Keys.DOWNLOAD_URL)) {
			app.setDownloadUrl(obj.getString(Configs.Keys.DOWNLOAD_URL));
		}

		if (!obj.isNull(Configs.Keys.SIZE)) {
			app.setSize(obj.getString(Configs.Keys.SIZE));
		}

		if (!obj.isNull(Configs.Keys.CATEGORY)) {
			app.setCategory(obj.getString(Configs.Keys.CATEGORY));
		}

		if (!obj.isNull(Configs.Keys.STARS)) {
			app.setStars(Float.valueOf(obj.getString(Configs.Keys.STARS)));			
		}

		if (!obj.isNull(Configs.Keys.NAME)) {
			app.setName(obj.getString(Configs.Keys.NAME));
		}
		if (!obj.isNull(Configs.Keys.GID_NAME)) {
			app.setGid(obj.getString(Configs.Keys.GID_NAME));
		}
		if (!obj.isNull(Configs.Keys.DOWNLOAD_TIMES)) {
			app.setDownloadTimes(obj.getString(Configs.Keys.DOWNLOAD_TIMES));
		}
		if (!obj.isNull(Configs.Keys.TAG)) {
			if(!"".equals(obj.getString(Configs.Keys.TAG))){
				app.setTag(Integer.parseInt(obj.getString(Configs.Keys.TAG)));
			}			
		}
		return app;
	}

	public static Game parseGame(JSONObject obj) throws JSONException {

		Game game = new Game();
		// 获取类别属性
		if (!obj.isNull(Configs.Keys.ICON)) {
			game.setIcon(obj.getString(Configs.Keys.ICON));
		}
		if (!obj.isNull(Configs.Keys.DESC)) {
			game.setDesc(obj.getString(Configs.Keys.DESC));
		}

		if (!obj.isNull(Configs.Keys.UPDATE_TIME)) {
			game.setUpdateTime(obj.getString(Configs.Keys.UPDATE_TIME));
		}

		if (!obj.isNull(Configs.Keys.LINK)) {
			game.setLink(obj.getString(Configs.Keys.LINK));
		}

		if (!obj.isNull(Configs.Keys.DOWNLOAD_URL)) {
			game.setDownloadUrl(obj.getString(Configs.Keys.DOWNLOAD_URL));
		}

		if (!obj.isNull(Configs.Keys.SIZE)) {
			game.setSize(obj.getString(Configs.Keys.SIZE));
		}

		if (!obj.isNull(Configs.Keys.VERSION)) {
			game.setVersion(obj.getString(Configs.Keys.VERSION));
		}
		if (!obj.isNull(Configs.Keys.CATEGORY)) {
			game.setCategory(obj.getString(Configs.Keys.CATEGORY));
		}

		if (!obj.isNull(Configs.Keys.CATE_ID)) {
			game.setCateId(obj.getString(Configs.Keys.CATE_ID));
		}
		if (!obj.isNull(Configs.Keys.STARS)) {
			game.setStars(Float.parseFloat(obj.getString(Configs.Keys.STARS)));
		}

		if (!obj.isNull(Configs.Keys.DEVELOPER)) {
			game.setDeveloper(obj.getString(Configs.Keys.DEVELOPER));
		}
		if (!obj.isNull(Configs.Keys.NAME)) {
			game.setName(obj.getString(Configs.Keys.NAME));
		}
		if (!obj.isNull(Configs.Keys.GID_NAME)) {
			game.setGid(obj.getString(Configs.Keys.GID_NAME));
		}
		if (!obj.isNull(Configs.Keys.DOWNLOAD_TIMES)) {
			game.setDownloadTimes(obj.getString(Configs.Keys.DOWNLOAD_TIMES));
		}
		if (!obj.isNull(Configs.Keys.NEED_UPDATE)) {
			game.setNeedUpdate(obj.getBoolean(Configs.Keys.NEED_UPDATE));
		}else{
			//没有属性默认为不用升级
			game.setNeedUpdate(false);
		}
		if (!obj.isNull(Configs.Keys.PACKAGE_NAME)) {
			game.setPackageName(obj.getString(Configs.Keys.PACKAGE_NAME));
		}
		if (!obj.isNull(Configs.Keys.VERSIONNAME)) {
			game.setVersionName(obj.getString(Configs.Keys.VERSIONNAME));
		}
		if (!obj.isNull(Configs.Keys.VERSIONCODE)) {
			game.setVersionCode(obj.getString(Configs.Keys.VERSIONCODE));
		}
		
		return game;
	}
	
	public static List<Game> parseGame(JSONArray array) throws JSONException {

		if (null != array && array.length() > 0) {
			List<Game> games = new ArrayList<Game>();
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				games.add(parseGame(obj));
			}
			return games;
		} else {
			return null;
		}
	}
	
	/**
	 * 解析新闻 攻略数据
	 * @param obj
	 * @return
	 * @throws JSONException
	 */
	public static News parseNews(JSONObject obj) throws JSONException {
		News news = new News();
		// 获取类别属性
		if (!obj.isNull(Configs.Keys.CONTENT)) {
			news.setContent(obj.getString(Configs.Keys.CONTENT));
		}
		if (!obj.isNull(Configs.Keys.ID)) {
			news.setId(obj.getInt(Configs.Keys.ID));
		}

		if (!obj.isNull(Configs.Keys.TITLE)) {
			news.setTitle(obj.getString(Configs.Keys.TITLE));
		}

		if (!obj.isNull(Configs.Keys.GID_NAME)) {
			news.setGid(obj.getString(Configs.Keys.GID_NAME));
		}

		if (!obj.isNull(Configs.Keys.DATE)) {
			news.setDate(obj.getString(Configs.Keys.DATE));
		}
		return news;
	}
	
	/**
	 * 解析新闻
	 * @param obj
	 * @return
	 * @throws JSONException
	 */
	public static NewsIndex parseNewsIndex(JSONObject obj) throws JSONException {
		
		NewsIndex newsIndex = new NewsIndex();
		// 获取类别属性
		if (!obj.isNull(Configs.Keys.NEWS)) {
			JSONArray jaArray = obj.getJSONArray(Configs.Keys.NEWS);
			if ( null != jaArray && jaArray.length() > 0 ){
			
				List<News> newsList = new ArrayList<News>();
				for (int i = 0; i < jaArray.length(); i++) {
					JSONObject jb = jaArray.getJSONObject(i);
					newsList.add(parseNews(jb));
				}
				newsIndex.setNews(newsList);
			}
		}
		if (!obj.isNull(Configs.Keys.REMAINS)) {
			newsIndex.setRemains(obj.getInt(Configs.Keys.REMAINS));
		}
		return newsIndex;
	}
}
