package com.banking.core;

public enum AccountType {
	SAVING(10000), CURRENT(5000), LOAN(15000), FD(20000);

	// adding a field
	private double balance;

	private AccountType(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

}
