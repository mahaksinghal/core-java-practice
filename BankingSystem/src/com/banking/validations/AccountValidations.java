package com.banking.validations;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.custom_exception.ExceptionHandling;

public class AccountValidations {

	public static final int AGE;
	
	// defining static initializer block
	static {
		AGE = 18;
	}

	public static AccountType parseAndValidateType(String accType) throws ExceptionHandling, IllegalArgumentException {
		AccountType myType = AccountType.valueOf(accType.toUpperCase());
		return myType;
	}

	public static void validateBalance(AccountType type, double balance) throws ExceptionHandling {
		if (balance < type.getBalance())
			throw new ExceptionHandling("Insufficient Balance");
	}

	public static LocalDate validateAge(String dob) throws ExceptionHandling {
		// conversion from string to date
		LocalDate date = LocalDate.parse(dob);
		// validation of Age
		int age = Period.between(date, LocalDate.now()).getYears();
		if (age < AGE)
			throw new ExceptionHandling("Minimum Age should be " + AGE);
		return date;
	}

	public static void uniqueID(int id, List<BankAccount> AccountList) throws ExceptionHandling {
		BankAccount account = new BankAccount(id);
		if (AccountList.contains(account))
			throw new ExceptionHandling("Account Already exists");
	}

//	public static int validateID(int accno, List<BankAccount> AccountList) throws ExceptionHandling {
//		BankAccount acc = new BankAccount(accno);
//		int index = AccountList.indexOf(acc);
//		if (index == -1)
//			throw new ExceptionHandling("Account not found by ID: " + accno);
//		return index;
//	}

}
