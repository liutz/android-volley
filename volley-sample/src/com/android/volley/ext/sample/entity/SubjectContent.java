package com.android.volley.ext.sample.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class SubjectContent implements Serializable {

	public String id;
	public String name;
	public String icon;
	public List<Game> games;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

}
