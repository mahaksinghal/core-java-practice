package com.cms.ui;

import java.util.Scanner;

import com.cms.service.CMSOperations;
import com.cms.service.CMSOperationsImpl;

public class CustomerManagementSystem {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create service layer - service impl class instance
			System.out.println("Enter size");
			CMSOperations ops = new CMSOperationsImpl(sc.nextInt());
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Register Customer\n"
						// + "2. Display All Accounts\n"
						+ "2. Sign In\n" + "0.Exit");
				System.out.println("Enter option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter your details: firstName, lastName, email\n"
								+ "		 password, regAmt, date of birth, Plan" + "\n Select Plan from\n"
								+ "Silver --> 1000, \r\n" + "	Gold --> 2000, \r\n" + "	Diamond --> 5000, \r\n"
								+ "	Platinum -->10000");
						System.out.println(ops.registerCustomer(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next()));
						break;
					case 2:
						System.out.println("Enter the email and password");
						System.out.println(ops.authenticate(sc.next(), sc.next()));
						break;
//					case 2: System.out.println("Customer Details are: ");
//						ops.displayCustomers();
//						break;
					case 0:
						exit = true;
						System.out.println("Program terminated");
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
