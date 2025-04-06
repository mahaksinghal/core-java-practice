package com.banking.operations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.banking.core.AccountType;
import com.banking.core.BankAccount;
import com.banking.custom_exception.ExceptionHandling;

import static com.banking.validations.AccountValidations.*;

public class BankingOperationsImpl implements BankingOperations {
	// state - memory allocated on the heap --->
	// upon instance creation ---> initialized to null
	private ArrayList<BankAccount> accounts = new ArrayList<>();

	public BankingOperationsImpl() {
		accounts = new ArrayList<>();
		System.out.println("Account Array Created");
		try {
			openAccount(10, "Rama", "Athavale", 12345, "savings", "2004-10-12");
			openAccount(100, "Mihir", "Kumar", 123450, "fixed", "2002-10-12");
			openAccount(1, "Rakesh", "Verma", 5345, "recurring", "2003-10-12");
			openAccount(50, "Anish", "Singh", 25345, "savings", "2000-06-12");
			openAccount(145, "Meetali", "Chauhan", 17345, "savings", "2006-11-12");
			openAccount(35, "Anuja", "Srivastava", 8345, "savings", "1999-03-12");
			openAccount(85, "Anuj", "Bhardwaj", 72945, "loan", "1999-03-12");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Account cannot be created");
		}
	}

	@Override
	public String openAccount(int accno, String firstName, String lastName,
			double balance, String type, String dob)
			throws ExceptionHandling, IllegalArgumentException {

		uniqueID(accno, accounts);
		AccountType mytype = parseAndValidateType(type);
		validateBalance(mytype, balance);
		LocalDate dateOfBirth = validateAge(dob);

		BankAccount account = new BankAccount(accno, firstName, lastName, 
				balance, mytype, dateOfBirth);
		accounts.add(account);

		return "Customer Registration Successful";
	}

	@Override
	public void displayAccounts() {
		System.out.println("All Accounts");
		for (BankAccount a : accounts) {
			System.out.println(a); // a.toString()
		}
	}

	@Override
	public BankAccount displayAccountById(int accNo) throws ExceptionHandling {
		BankAccount acc = new BankAccount(accNo);
		int index = accounts.indexOf(acc);
		if (index == -1)
			throw new ExceptionHandling("Account not found by ID: " + accNo); 	
//		int index = validateID(accNo, accounts);
		return accounts.get(index);
	}

	@Override
	public String withdrawFunds(int accNo, double amount) throws ExceptionHandling {
		// get account by accNo
		BankAccount account = displayAccountById(accNo);
		AccountType type = account.getType();
		// validateBalance
		double amt = account.getBalance() - amount;
		validateBalance(type, amt);
		// setter and getter
		account.setBalance(amt);
		return "Funds are withdrawn from the account";
		}

	@Override
	public String depositFunds(int accNo, double amount) throws ExceptionHandling {
		// get account by accNo
		BankAccount account = displayAccountById(accNo);
		//AccountType type = account.getType();
		// setter and getter
		double amt = account.getBalance() + amount;
//		validateBalance(type, amt);
		account.setBalance(amt);
		return "Funds are deposited in the account";
	}

	@Override
	public void transferFunds(int accNo, double amount, int transferedAccNo) 
			throws ExceptionHandling {
		
		System.out.println(withdrawFunds(accNo, amount));
		
		System.out.println(depositFunds(transferedAccNo, amount));
	}
	
	@Override
	public void closeAccount(int accNo) throws ExceptionHandling{
		// attach iterator
		Iterator<BankAccount> accountItr = accounts.iterator();
		// cursor - before the first element
		while(accountItr.hasNext()) {
			BankAccount a = accountItr.next();
			if(a.getAccno() == accNo) {
				accountItr.remove();
				System.out.println(a.getName());
			}
		}
	}
	
	@Override
	public void sortByAccNo() {
		Collections.sort(accounts);
	}
	
	@Override
	public void sortByAccType() {
		Collections.sort(accounts, new Comparator<BankAccount>() {
			
			@Override
			public int compare(BankAccount a1, BankAccount a2) {
				return a1.getType().compareTo(a2.getType());
				
			}
		});
	}
	
	@Override
	public void sortByDobAndBalance() {
		 Collections.sort(accounts, new Comparator<BankAccount>() {
			 
			 @Override
			 public int compare(BankAccount a1, BankAccount a2) {
				 int retVal = a1.getDob().compareTo(a2.getDob());
				 if(retVal == 0) {
					 // do this or if you want to reduce the code, then
//					 if(a1.getBalance() < a2.getBalance())
//						 return -1;
//					 if(a1.getBalance() == a2.getBalance())
//						 return 0;
//					 return 1;
					 
					 // do this
					 return ((Double)a1.getBalance()).compareTo(a2.getBalance());
				 }
				 return retVal;
			 }
			 
		});
	}
	
	
}
