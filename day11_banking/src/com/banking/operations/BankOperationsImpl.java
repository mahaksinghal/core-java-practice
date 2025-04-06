package com.banking.operations;

import static com.banking.validations.BankingValidations.*;

import java.time.LocalDate;
import java.util.ArrayList;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.custom_exceptions.BankingException;

public class BankOperationsImpl implements BankOperations {
	private ArrayList<BankAccount> accounts;

	public BankOperationsImpl() throws BankingException {
		// create empty AL
		accounts = new ArrayList<>(1000);
		createAccount(10, "Rama_Athavale", 12345, "2024-10-12", "saving");
		createAccount(100, "Mihir", 123450, "2022-10-12", "fd");
		createAccount(1, "Rakesh", 5345, "2023-10-12", "current");
		createAccount(50, "Anish", 25345, "2022-06-12", "saving");
		createAccount(145, "Meetali", 17345, "2024-11-12", "saving");
		createAccount(35, "Anuja", 8345, "2025-03-12", "saving");

	}

	@Override
	public String createAccount(int acctNo, String customerName, int openingBalnce, String openingDate, String acctType)
			throws BankingException {
		// validate opening balance
		validateBalance(openingBalnce);
		// validate account type
		AccountType type = validateAccountType(acctType);
		// convert string -> LocalDate
		LocalDate date = LocalDate.parse(openingDate);
		// create bank account object n store it in the list
		BankAccount account = new BankAccount(acctNo, customerName, openingBalnce, date, type);
		accounts.add(account);
		return "new a/c created !";

	}

	@Override
	public BankAccount getAccountSummary(int acctNo) throws BankingException {
		// find index of 1st occurrence of specific account - indexOf

		return null;
	}

	public String depositFunds(int acctNo, int amount) throws BankingException {

		return "Funds deposited in the a/c ";
	}

	@Override
	public String closeAccount(int acctNo) throws BankingException {
		return "Closed the a/c ";
	}

}
