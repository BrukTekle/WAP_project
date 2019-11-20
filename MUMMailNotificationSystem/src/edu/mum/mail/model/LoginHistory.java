package edu.mum.mail.model;

import java.time.LocalDateTime;

public class LoginHistory {

	private String userId;
	private LocalDateTime loginDate;
	private LocalDateTime logOutDate;
	private String ipAddress;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}
	public LocalDateTime getLogOutDate() {
		return logOutDate;
	}
	public void setLogOutDate(LocalDateTime logOutDate) {
		this.logOutDate = logOutDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	} 
}
