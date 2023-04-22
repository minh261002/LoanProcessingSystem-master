package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class Account {

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	private int id, authId;
	private String name, email, password, phone, address, authName, identityCard;
	private Date dob;
	private boolean gender, status;

	public Account() {
		super();
	}

	public Account(int id, int authId, String name, String email, String password, String phone, String address,
			String authName, String identityCard, Date dob, boolean gender, boolean status) {
		super();
		this.id = id;
		this.authId = authId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.authName = authName;
		this.identityCard = identityCard;
		this.dob = dob;
		this.gender = gender;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", authId=" + authId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + ", identity_card=" + identityCard
				+ ", gender=" + gender + ", dob=" + dob + ", status=" + status + "]";
	}

}