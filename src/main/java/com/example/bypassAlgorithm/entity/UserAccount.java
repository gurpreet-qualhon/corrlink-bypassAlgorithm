/**
 * 
 */
package com.example.bypassAlgorithm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Gurpreet Singh
 *
 */
@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue
	private long id;
	public UserAccount(long id, String email, String password, String deviceInfo, String deviceName, String fireBaseToken, String clientDeviceId, String authToken, int user_id, String uuid) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.deviceInfo = deviceInfo;
		this.deviceName = deviceName;
		this.fireBaseToken = fireBaseToken;
		this.clientDeviceId = clientDeviceId;
		this.authToken = authToken;
		this.user_id = user_id;
		this.uuid = uuid;
	}
	
	public UserAccount() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getFireBaseToken() {
		return fireBaseToken;
	}
	public void setFireBaseToken(String fireBaseToken) {
		this.fireBaseToken = fireBaseToken;
	}
	public String getClientDeviceId() {
		return clientDeviceId;
	}
	public void setClientDeviceId(String clientDeviceId) {
		this.clientDeviceId = clientDeviceId;
	}
	private String email;
	@Column(columnDefinition = "TEXT")
	private String password;
	@Column(columnDefinition = "TEXT")
	private String deviceInfo;
	@Column(columnDefinition = "TEXT")
	private String deviceName;	
	@Column(columnDefinition = "TEXT")
	private String fireBaseToken;
	@Column(columnDefinition = "TEXT")
	private String clientDeviceId;
	private String authToken;
	private String uuid;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	private int user_id;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", email=" + email + ", password=" + password + ", deviceInfo=" + deviceInfo
				+ ", deviceName=" + deviceName + ", fireBaseToken=" + fireBaseToken + ", clientDeviceId="
				+ clientDeviceId + ", authToken=" + authToken + ", uuid=" + uuid + ", user_id=" + user_id + "]";
	}

	
}
