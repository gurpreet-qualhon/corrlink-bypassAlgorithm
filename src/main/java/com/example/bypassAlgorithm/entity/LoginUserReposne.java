package com.example.bypassAlgorithm.entity;

public class LoginUserReposne {
	
	private int userId;
	public LoginUserReposne() {}
	public LoginUserReposne(int userId, String authToken, int status, String responseBody, String customAuthToken) {
		super();
		this.userId = userId;
		this.authToken = authToken;
		this.status = status;
		this.responseBody = responseBody;
		this.customAuthToken = customAuthToken;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private String authToken;
	private int status;
	private String responseBody;
	private String customAuthToken;
	public String getCustomAuthToken() {
		return customAuthToken;
	}
	public void setCustomAuthToken(String customAuthToken) {
		this.customAuthToken = customAuthToken;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	
}
