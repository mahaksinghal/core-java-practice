package com.cms.core;

import java.time.LocalDate;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private static int idGenerator = 0; // auto generator the customer id
	private ServicePlan plan; // enum

	// Parameterized Constructor
	public Customer(String fn, String ln, String email, String password, double regAmt, LocalDate dob,
			ServicePlan plan) {
		this.customerId = ++idGenerator;
		firstName = fn;
		lastName = ln;
		this.email = email;
		this.password = password;
		regAmount = regAmt;
		this.dob = dob;
		this.plan = plan;
	}

	// Overloading a parameterized constructor for findByEmail method
	public Customer(String email) {
		this.email = email;
	}

	// Override toString method to print customer details
	@Override
	public String toString() {
		return "Customer Details: " + "id: " + customerId + "\nName: " + firstName + " " + lastName + "\nEmail: "
				+ email + "\nRegistration Amount: " + regAmount + "\nDate of Birth: " + dob;
	}

	// Override equals method for customer email checking
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			Customer customer = (Customer) obj;
			return this.email.equals(customer.email);
		}
		return false;
	}

	// Getter for Id
	public int getCustomerId() {
		return customerId;
	}

	// getter for name
	public String getName() {
		return firstName + " " + lastName;
	}

	// getter for email
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	// getter for date
	public LocalDate getDate() {
		return dob;
	}

	// getter for plan selected by the user
	public String getPlan() {
		return plan.name().toLowerCase();
	}

	// getter for amount
	public double getRegAmount() {
		return regAmount;
	}

}
