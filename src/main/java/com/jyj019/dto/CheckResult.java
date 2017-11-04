package com.jyj019.dto;
/**
 *
 *@Author jyj019
 **/
public class CheckResult {
	private String username;
	private boolean valid;
	private String message;
	private String picture;
	
	public CheckResult() {
	}
	public CheckResult(String username,boolean valid, String message, String picture) {
		this.setUsername(username);
		this.valid = valid;
		this.message = message;
		this.picture = picture;
	}

	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
