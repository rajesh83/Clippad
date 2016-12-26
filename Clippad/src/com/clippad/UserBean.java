package com.clippad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserBean implements Serializable  {
	
	private static final long serialVersionUID = 1234L;
	
	private String user = null;
	private String pswd = null;
	private String name = null;
	
	List clips = null;
	
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
	public List getClips() {
		return clips;
	}
	public void setClips(List clips) { 
		this.clips = clips;
	}
}
