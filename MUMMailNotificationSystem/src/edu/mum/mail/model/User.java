package edu.mum.mail.model;

import java.io.Serializable;
import java.security.Key;
import java.sql.Array;

public class User implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
	private String UserName;
	private String password;
	private int role;
	private int personId;
	private byte[] key;
	public User() {
		
	}
	public User(String UserName, int role,int personId) {
		this.UserName=UserName;
		this.role=role;
		this.personId=personId;
		
	}
	public User(String UserName,String password, int role,int personId) {
		this.UserName=UserName;
		this.password=password;
		this.role=role;
		this.personId=personId;
		
	}
	public User(String UserName, String password) {
		this.UserName=UserName;
		this.password=password;
		
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String UserName) {
		this.UserName = UserName;
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
	public byte[] getKey() {
		return  key;
	}
	public void setKey(byte[] key2) {
		this.key = key2;
	}
	
}
