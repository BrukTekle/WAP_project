package edu.mum.mail.model;

public class user {
	private String userName;
	private String password;
	private int role;
	private int personId;
	
	public user() {
		
	}
	public user(String userName, String password) {
		this.userName=userName;
		this.password=password;
		
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
}
