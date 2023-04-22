package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class LoanAndFineHistory {
	private int id;
	private int loanId;
	private String customer;
	private int fineId;
	private int paymentMethodId;
	private String paymentMenthodName;
	private double paymentAmount;
	private double amountLeft;
	private Date dueDate;
	private float fineInterest;
	private int fineOverDays;
	private double fineAmount;
	private Date paymentDate;
	private String description;
	private boolean status;
	private double amount;
	private String loanType;
	private String paymentType;
	private int period;
	private int duration;
	private Date endDate;
	private double loanInterest;

	public LoanAndFineHistory() {
		super();
	}

	public LoanAndFineHistory(int id, int loanId, String customer, int fineId, int paymentMethodId,
			String paymentMenthodName, double paymentAmount, double amountLeft, Date dueDate, float fineInterest,
			int fineOverDays, double fineAmount, Date paymentDate, String description, boolean status, double amount,
			String loanType, String paymentType, int period, int duration, Date endDate, double loanInterest) {

		super();
		this.id = id;
		this.loanId = loanId;
		this.customer = customer;
		this.fineId = fineId;
		this.paymentMethodId = paymentMethodId;
		this.paymentMenthodName = paymentMenthodName;
		this.paymentAmount = paymentAmount;
		this.amountLeft = amountLeft;
		this.dueDate = dueDate;
		this.fineInterest = fineInterest;
		this.fineOverDays = fineOverDays;
		this.fineAmount = fineAmount;
		this.paymentDate = paymentDate;
		this.description = description;
		this.status = status;
		this.amount = amount;
		this.loanType = loanType;
		this.paymentType = paymentType;
		this.period = period;
		this.duration = duration;
		this.endDate = endDate;
		this.loanInterest = loanInterest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMenthodName() {
		return paymentMenthodName;
	}

	public void setPaymentMenthodName(String paymentMenthodName) {
		this.paymentMenthodName = paymentMenthodName;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getAmountLeft() {
		return amountLeft;
	}

	public void setAmountLeft(double amountLeft) {
		this.amountLeft = amountLeft;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public float getFineInterest() {
		return fineInterest;
	}

	public void setFineInterest(float fineInterest) {
		this.fineInterest = fineInterest;
	}

	public int getFineOverDays() {
		return fineOverDays;
	}

	public void setFineOverDays(int fineOverDays) {
		this.fineOverDays = fineOverDays;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(float loanInterest) {
		this.loanInterest = loanInterest;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
