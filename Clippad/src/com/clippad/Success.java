package com.clippad;


import java.io.Serializable;

public class Success implements Serializable {
	
		private static final long serialVersionUID = 1234L;
		
		String title;
		String header;
		String message;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getHeader() {
			return header;
		}
		public void setHeader(String header) {
			this.header = header;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
}
