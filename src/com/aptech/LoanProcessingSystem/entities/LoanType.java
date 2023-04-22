package com.aptech.LoanProcessingSystem.entities;

public class LoanType {

	private int id;
	private double interest;
	private String name;
	private String description;
	private boolean status;

	public LoanType() {
		super();
	}

	public LoanType(int id, float interest, String name, String description, boolean status) {
		super();
		this.id = id;
		this.interest = interest;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
