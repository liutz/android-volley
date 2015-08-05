package com.android.volley.ext.sample.entity;

import java.io.Serializable;

/**
 * 专题
 * 
 * @author hongtaozhang Aug 20, 2013
 */
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5688488728376132797L;
	public String id;
	public String name;
	public String img;
	public int index; //数据采集第几个

	public Subject(String id, String name, String img) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
	}

	public Subject(String id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", img=" + img + "]";
	}
	

}
