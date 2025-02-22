package com.emtity;



public class Recepation {
	
	private int id;
	private String UserName;
	private String password;
	
	public Recepation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recepation(String userName, String password) {
		super();
	    this.UserName = userName;
		this.password = password;
	}
	
	
	
	


	public Recepation(int id, String userName, String password) {
		super();
		this.id = id;
		this.UserName = userName;
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
