package com.read.vo;

import java.io.Serializable;
import java.util.Map;

public class MarkList implements Serializable{

	Map<String,Bookmark> map;

	public Map<String,Bookmark> getMap() {
		return map;
	}

	public void setMap(Map<String,Bookmark> map) {
		this.map = map;
	}

	
	
}
