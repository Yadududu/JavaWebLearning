package com.lmj.model;

public class User {
	private String username;
	private String password;
	private String sex;
	private int phoneNumber;
	private boolean isAdmin;
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public User(String username, String password, String sex, int phoneNumber, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
	}
}
