package com.emtity;

public class AddAmbulance {

	private int id;
	private String carnumber;
	private String available;
	private String address;
	
	public AddAmbulance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddAmbulance(String carnumber, String available, String address) {
		super();
		this.carnumber = carnumber;
		this.available = available;
		this.address = address;
	}

	public AddAmbulance(int id, String carnumber, String available, String address) {
		super();
		this.id = id;
		this.carnumber = carnumber;
		this.available = available;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
