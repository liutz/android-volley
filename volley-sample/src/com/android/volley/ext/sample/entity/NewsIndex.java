package com.android.volley.ext.sample.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author hongtaozhang Aug 27, 2013
 */
public class NewsIndex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4770469427098997417L;
	private List<News> news;
	private Integer remains;

	
	public NewsIndex() {
		super();
	}

	public NewsIndex(List<News> news, Integer remains) {
		super();
		this.news = news;
		this.remains = remains;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public Integer getRemains() {
		return remains;
	}

	public void setRemains(Integer remains) {
		this.remains = remains;
	}

}
