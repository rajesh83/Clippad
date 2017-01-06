package com.clippad;


public class LoginBean {
	
	private String user = null;
	private String pswd = null;
	private boolean isLoggedin = false;
	private String message = null;
	private String msgClass = null;
	
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String error) {
		this.message = error;
	}
	public String getMsgClass() {
		return msgClass;
	}
	public void setMsgClass(String msgClass) {
		this.msgClass = msgClass;
	}
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public void setLoggedin(boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
}
