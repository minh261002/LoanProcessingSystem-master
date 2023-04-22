package com.aptech.LoanProcessingSystem.entities;

public class Fine {
	private int id;
	private float fineInterest;
	private double min;
	private double max;
	private String description;
	private boolean status;
	public Fine() {
		super();
	}
	public Fine(int id, float fineInterest, double min, double max, String description, boolean status) {
		super();
		this.id = id;
		this.fineInterest = fineInterest;
		this.min = min;
		this.max = max;
		this.description = description;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getFineInterest() {
		return fineInterest;
	}
	public void setFineInterest(float fineInterest) {
		this.fineInterest = fineInterest;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
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
