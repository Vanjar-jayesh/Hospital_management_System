package com.emtity;



public class Room {

	private int id;
	private String type;
	private String capacity;
	private String availablity;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String type, String capacity, String availablity) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.availablity = availablity;
	}

	public Room(int id, String type, String capacity, String availablity) {
		super();
		this.id = id;
		this.type = type;
		this.capacity = capacity;
		this.availablity = availablity;
	}

	
	public Room(String availablity) {
		super();
		this.availablity = availablity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getAvailablity() {
		return availablity;
	}

	public void setAvailablity(String availablity) {
		this.availablity = availablity;
	}
	
	
	
	
	
	
}
