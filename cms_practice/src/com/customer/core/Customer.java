package com.customer.core;

import java.time.LocalDate;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	// customer id generator
	public static int idGenerator;

	public Customer(String firstName, String lastName, String email, String password, String phone, double regAmount, LocalDate dob,
			ServicePlan plan) {
		this.customerId = ++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("In Equals");
		if(obj instanceof Customer)
			return this.email.equals(((Customer)obj).email);
		return false;
	}
	
	@Override
	public int hashCode() {
		System.out.println("In hashCode");
		return this.email.hashCode();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phone=" + phone + ", regAmount=" + regAmount + ", dob=" + dob
				+ ", plan=" + plan.toString().toLowerCase() + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	

}
