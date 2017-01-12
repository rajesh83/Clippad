package com.clippad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable  {
	
	private static final long serialVersionUID = 1234L;
	
	private String user = null;
	private String pswd = null;
	private String name = null;
	
	List<String> clipTitle = new ArrayList<String>();
	List<String> clipText = new ArrayList<String>();
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getClipText() {
		return clipText;
	}
	public void setClipText(List<String> clipText) { 
		this.clipText = clipText;
	}
	public List<String> getClipTitle() {
		return clipTitle;
	}
	public void setClipTitle(List<String> clipTitle) {
		this.clipTitle = clipTitle;
	}
}
