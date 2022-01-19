package com.exam.model;

public class JWTRequest {
	private String userName;
	private String password;

	public JWTRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public JWTRequest() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
