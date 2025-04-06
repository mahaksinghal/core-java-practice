package com.banking.operations;

import com.banking.core.BankAccount;
import com.banking.custom_exception.ExceptionHandling;

public interface BankingOperations {
	
	// method to open a bank account
	String openAccount(int accno, String fn, String ln, 
			double balance, String type, String dob) throws ExceptionHandling, IllegalArgumentException;

	// method to display all account in the bank
	void displayAccounts();
	
	// method to display bank account given by user
	BankAccount displayAccountById(int accno) throws ExceptionHandling;

	// method to withdraw the funds from a bank account
	String withdrawFunds(int accNo, double amount) throws ExceptionHandling;

	// method to deposit the funds in the bank account
	String depositFunds(int accNo, double amount) throws ExceptionHandling;
	
	// method to transfer funds from one bank account to another
	void transferFunds(int accNo, double amount, int anotherAccNo) throws ExceptionHandling;
	
	// method to close the bank account
	void closeAccount(int accNo) throws ExceptionHandling;
	
	// method to sort the BankAccount by Account Number (using natural ordering)
	void sortByAccNo();
	
	// method to sort the BankAccount by Account Type (using custom ordering and anonymous inner class)
	void sortByAccType();
	
	// method to sort the BankAccount by DOB and Balance (using custom ordering and anonymous inner class)
	void sortByDobAndBalance();

}