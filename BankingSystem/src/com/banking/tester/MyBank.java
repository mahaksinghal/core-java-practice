package com.banking.tester;

import java.util.Scanner;

import com.banking.operations.BankingOperations;
import com.banking.operations.BankingOperationsImpl;

public class MyBank {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create bank operations implementation class instance
			BankingOperations ops = new BankingOperationsImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("---------------Menu-------------------\n"
						+ "1. Open account\n" 
						+ "2. Display all\n" 
						+ "3. Search Account by ID\n"
						+ "4. Deposit Amount\n" 
						+ "5. Withdraw Amount\n" 
						+ "6. Transfer Amount\n" 
						+ "7. Close Account\n" 
						+ "8. Sorting By Account Number\n"
						+ "9. Sort as Per the Account Type\n"
						+ "10. Sort as Per Customer's DOB and Balance\n"
						+ "0. Exit\n");
				System.out.println("Enter Your Choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter your account details: "
								+ "account number, first name, last name, balance, "
								+ "\ntype: (Savings, Fixed, Recurring, Demat)\n" + 
								"		dob - year, month, day");
						System.out.println(ops.openAccount(sc.nextInt(), sc.next(), sc.next(), 
								sc.nextDouble(), sc.next(), sc.next()));
						break;
					case 2:
						ops.displayAccounts();
						break;
					case 3:
						System.out.println("Enter account number");
						System.out.println(ops.displayAccountById(sc.nextInt()));
						break;
					case 4:
						System.out.println("Enter account number and deposit amount");
						System.out.println(ops.depositFunds(sc.nextInt(), sc.nextInt()));
						break;
					case 5:
						System.out.println("Enter account number and withdrawl amount");
						System.out.println(ops.withdrawFunds(sc.nextInt(), sc.nextInt()));
						break;
					case 6: 
						System.out.println("Enter account number, transfer amount and "
								+ "account number in which it is to be transferred");
						ops.transferFunds(sc.nextInt(), sc.nextDouble(), sc.nextInt());
						break;
					case 7:
						System.out.println("Enter the account number to be closed");
						ops.closeAccount(sc.nextInt());
						break;
					case 8:
						System.out.println("Sorting By Account Number");
						ops.sortByAccNo();
						break;
					case 9:
						System.out.println("Sorting By Account Type");
						ops.sortByAccType();
						break;
					case 10:
						System.out.println("Sorting By Customer Dob and Balance");
						ops.sortByDobAndBalance();
						break;
					case 0:
						exit = true;
						System.out.println("Program Terminated");
						break;

					}
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Please try again");
					sc.nextLine();
				}
			}
		}
	}
}

/*
 * 1 a1 b1 20000 savings 2000-01-01 
 * 2 a2 b2 50000 fixed 1999-01-01 
 * 3 a3 b3 299999 recurring_deposit 1987-08-23 
 * 4 a4 b4 234334 savings 2005-10-18
 */















