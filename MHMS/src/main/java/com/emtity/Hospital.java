package com.emtity;

public class Hospital {

	private int id;
	private String UserName;
	private String password;
	
	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String userName, String password) {
		super();
		UserName = userName;
		this.password = password;
	}

	public Hospital(int id, String userName, String password) {
		super();
		this.id = id;
		UserName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
