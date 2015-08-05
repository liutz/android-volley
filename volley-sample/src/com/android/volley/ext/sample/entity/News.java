package com.android.volley.ext.sample.entity;

import java.io.Serializable;

/**
 * 
 * @author hongtaozhang Aug 27, 2013
 */
public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4823454773353557083L;
	private Integer id;
	private String title;
	private String gid;
	private String date;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
