package com.emtity;

public class Appointment {

	private int id;
	private int userId;
//	private String name;
	private String fullname;
	private String gender;
	private String age;
	private String appoinDate;
	private String AadharNumber;
	private String PhNo;
	private String diseases;
//	private String doctorId;
	private int doctorId;	
	private String address;
	private String status;
	
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
//public Appointment(String name, String gender, String age, String appoinDate, String aadharNumber, String phNo,
//		String diseases, String doctorId, String address) {
//	super();
//	this.name = name;
//	this.gender = gender;
//	this.age = age;
//	this.appoinDate = appoinDate;
//	AadharNumber = aadharNumber;
//	PhNo = phNo;
//	this.diseases = diseases;
//	this.doctorId = doctorId;
//	this.address = address;
//}
//public int getId() {
//	return id;
//}
//public void setId(int id) {
//	this.id = id;
//}
//public String getname() {
//	return name;
//}
//public void setname(String name) {
//	this.name = name;
//}
//public String getGender() {
//	return gender;
//}
//public void setGender(String gender) {
//	this.gender = gender;
//}
//public String getAge() {
//	return age;
//}
//public void setAge(String age) {
//	this.age = age;
//}
//public String getAppoinDate() {
//	return appoinDate;
//}
//public void setAppoinDate(String appoinDate) {
//	this.appoinDate = appoinDate;
//}
//public String getAadharNumber() {
//	return AadharNumber;
//}
//public void setAadharNumber(String aadharNumber) {
//	AadharNumber = aadharNumber;
//}
//public String getPhNo() {
//	return PhNo;
//}
//public void setPhNo(String phNo) {
//	PhNo = phNo;
//}
//public String getDiseases() {
//	return diseases;
//}
//public void setDiseases(String diseases) {
//	this.diseases = diseases;
//}
//public String getDoctorId() {
//	return doctorId;
//}
//public void setDoctorId(String doctorId) {
//	this.doctorId = doctorId;
//}
//public String getAddress() {
//	return address;
//}
//public void setAddress(String address) {
//	this.address = address;
//}

	

	public Appointment(int userId, String fullName, String gender, String age, String appoinDate, String aadharNumber,
			String phNo, String diseases, int doctorId, String address, String status) {
		super();
		this.userId = userId;
		this.fullname = fullName;
		this.gender = gender;
		this.age = age;
		this.appoinDate = appoinDate;
		AadharNumber = aadharNumber;
		PhNo = phNo;
		this.diseases = diseases;
		this.doctorId = doctorId;
		this.address = address;
		this.status = status;
	}

	


	public Appointment(int doctorId) {
	super();
	this.doctorId = doctorId;
}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getAppoinDate() {
		return appoinDate;
	}



	public void setAppoinDate(String appoinDate) {
		this.appoinDate = appoinDate;
	}



	public String getAadharNumber() {
		return AadharNumber;
	}



	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}



	public String getPhNo() {
		return PhNo;
	}



	public void setPhNo(String phNo) {
		PhNo = phNo;
	}



	public String getDiseases() {
		return diseases;
	}



	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}



	public int getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	
}