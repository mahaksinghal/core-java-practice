package com.banking.core;

import java.time.LocalDate;

public class BankAccount implements Comparable<BankAccount> {
//	private String accno;
	private int accno;
	private String firstName;
	private String lastName;
	private double balance;
//	private String type;
	private AccountType type;
	private LocalDate dob;

	// Parameterized Constructor
	public BankAccount(int accno, String fn, String ln, double balance, AccountType type, LocalDate dob) {
		this.accno = accno;
		firstName = fn;
		lastName = ln;
		this.balance = balance;
		this.type = type;
		this.dob = dob;
	}
	
	// Overloaded Constructor
	public BankAccount(int accno){
		this.accno = accno;
	}

	@Override
	public String toString() {
		return "Account Number: " + accno + ", Name: " + firstName + " " + lastName + ", Balance: " + balance
				+ ", Type: " + type + ", Date of Birth: " + dob;
	}

	@Override
	public boolean equals(Object anotherObj) {
		if (anotherObj instanceof BankAccount) {
			/*
			 * this is used when accno is String BankAccount anotherAccount =
			 * ((BankAccount)anotherObj); return this.accno.equals(anotherAccount.accno);
			 */
			BankAccount account = (BankAccount)anotherObj;
			return this.accno == account.accno;
		}
		return false;
	}
	
	@Override
	public int compareTo(BankAccount anotherAccount) {
		if(this.accno < anotherAccount.accno)
			return -1;
		if(this.accno == anotherAccount.accno)
			return 0;
		return 1;
	}

	public int getAccno() {
		return accno;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public double getBalance() {
		return balance;
	}

	public AccountType getType() {
		return type;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	
	
}
