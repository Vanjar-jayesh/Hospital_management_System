package com.emtity;

public class AddDepartment {

	private int id;
	private String DName;
	private String Pnumber;
	
	public AddDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddDepartment(String dName, String pnumber) {
		super();
		DName = dName;
		Pnumber = pnumber;
	}

	public AddDepartment(int id, String dName, String pnumber) {
		super();
		this.id = id;
		DName = dName;
		Pnumber = pnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDName() {
		return DName;
	}

	public void setDName(String dName) {
		DName = dName;
	}

	public String getPnumber() {
		return Pnumber;
	}

	public void setPnumber(String pnumber) {
		Pnumber = pnumber;
	}
	
	
	
	
	
}
