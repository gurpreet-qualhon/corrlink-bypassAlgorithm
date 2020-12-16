package com.example.bypassAlgorithm.entity;

public class LoginAccount {
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public LoginAccount() {}
	public LoginAccount(String email, String deviceName, String responseBody) {
		super();
		this.email = email;
		this.deviceName = deviceName;
		this.responseBody = responseBody;
	}
	private String deviceName;
	private String responseBody;
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
}
