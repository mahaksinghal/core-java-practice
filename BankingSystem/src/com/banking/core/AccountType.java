package com.banking.core;

public enum AccountType {
	SAVINGS(5000), 
	FIXED(2000), 
	RECURRING(1000), 
	DEMAT(4000), 
	LOAN(10000);

	// adding a field
	private double balance;

	private AccountType(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

}
