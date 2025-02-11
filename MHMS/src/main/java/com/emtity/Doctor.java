package com.emtity;

public class Doctor {
	


	
	private int id;
	private String fullName;
	private String dob;
	private String qualification;
	private String email;
	private String mobNO;
	private String password;
	private String Specialist;
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	
//	public Doctor(String fullName, String dob, String qualification, String email, String mobNO, String password) {
//		super();
//		this.fullName = fullName;
//		this.dob = dob;
//		this.qualification = qualification;
//		this.email = email;
//		this.mobNO = mobNO;
//		this.password = password;
//	}

	





	public Doctor(String fullName, String dob, String qualification, String email, String mobNO, String password,
		String specialist) {
	super();
	this.fullName = fullName;
	this.dob = dob;
	this.qualification = qualification;
	this.email = email;
	this.mobNO = mobNO;
	this.password = password;
	this.Specialist = specialist;
}
	
	
	
	
	public Doctor(int id, String fullName, String dob, String qualification, String email, String mobNO, String password,
		String specialist) {
	super();
	this.id = id;
	this.fullName = fullName;
	this.dob = dob;
	this.qualification = qualification;
	this.email = email;
	this.mobNO = mobNO;
	this.password = password;
	Specialist = specialist;
}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getQualification() {
		return qualification;
	}



	public void setQualification(String qualification) {
		this.qualification = qualification;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobNO() {
		return mobNO;
	}



	public void setMobNO(String mobNO) {
		this.mobNO = mobNO;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getSpecialist() {
		return Specialist;
	}


	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}
	
	
	
	
	
	
	
	
	
	
	
}
