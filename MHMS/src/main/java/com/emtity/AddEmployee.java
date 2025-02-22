package com.emtity;

public class AddEmployee {

	private int id;
	private String name;
	private String age;
	private String dob;
	private String PNumber;
	private String salary;
	private String email;
	private String Adnumber;
	

	public AddEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddEmployee(String name, String age, String dob, String pNumber, String salary, String email,
			String adnumber) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		PNumber = pNumber;
		this.salary = salary;
		this.email = email;
		Adnumber = adnumber;
	}

	public AddEmployee(int id, String name, String age, String dob, String pNumber, String salary, String email,
			String adnumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = dob;
		PNumber = pNumber;
		this.salary = salary;
		this.email = email;
		Adnumber = adnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPNumber() {
		return PNumber;
	}

	public void setPNumber(String pNumber) {
		PNumber = pNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdnumber() {
		return Adnumber;
	}

	public void setAdnumber(String adnumber) {
		Adnumber = adnumber;
	}

	
	
	
	
	
	
	
}
