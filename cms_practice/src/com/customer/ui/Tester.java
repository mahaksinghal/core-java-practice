package com.customer.ui;

import java.util.Scanner;

import com.customer.core.Customer;
import com.customer.services.CustomerServices;
import com.customer.services.CustomerServicesImpl;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			CustomerServices ops = new CustomerServicesImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("----------------Options------------------- \n "
						+ "1. Sign Up Customer \n " 
						+ "2. Sign In \n " 
						+ "3. Display all customers \n "
						+ "4. Display all customers born after specified date \n "
						+ "5. Upgrade all senior customers of Silver Plan to Gold \n " 
						+ "6. Change password \n "
						+ "7. Un subscribe Customer by email \n " 
						+ "8. Delete all the customers by specified plan  \n "
						+ "9. Sort customers as per email  \n " 
						+ "10. Sort customers as per dob  \n "
						+ "11. Sort customers as per dob(Asc) n reg amount(desc)  \n "
						+ "12. Sort customers as per last names  \n "
						+ "13. Sort customers as per Service Plan names \n "

						+ "0. Exit");
				System.out.println("Enter Your Choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer Details - \n"
								+ "		firstName, lastName, email, password, phone,\r\n"
								+ "			regAmount, dob (yyyy-mm-dd),\n"
								+ "plan----> "
								+ "Silver(1000), \r\n"
								+ "	Gold(2000), \r\n"
								+ "	Diamond(5000), \r\n"
								+ "	Platinum(10000)");
						System.out.println(ops.signUpCustomers(sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.next()));
						break;
						
					case 2: 
						System.out.println("Enter email, password to sign in");
						Customer authenticatedCustomer = ops.signInCustomer(sc.next(), sc.next());
						System.out.println("Welcome" + authenticatedCustomer.getFirstName() + " " + authenticatedCustomer.getLastName());
						break;
						
					case 3: 
						ops.displayCustomers();
						break;
						
					case 4:
						System.out.println("Enter the date (yyyy-mm-dd)");
						ops.displayCustomerBeforeSpecifiedDate(sc.next());
						break;
						
					case 5:
						ops.UpdateCustomers();
						System.out.println("Customers updated");
						break;
						
					case 6:
						System.out.println("Enter email, old password and new password to update");
						ops.updatePassword(sc.next(), sc.next(), sc.next());
						break;
						
					case 7:
						System.out.println("Enter email to unsubscribe");
						System.out.println(ops.unsubcribeCustomer(sc.next()));
						break;
						
					case 8:
						System.out.println("enter the plan to remove the customer");
						ops.removeByPlan(sc.next());
						break;
						
					case 9: 
						ops.sortByEmail();
						break;
						
					case 10: 
						ops.sortByDOB();
						break;
					case 11:
						ops.sortByDobAmount();
						break;
						
					case 12:
						ops.sortByLastNames();
						break;
						
					case 13:
						ops.sortByServicePlanNames();
						break;
						
					case 0: 
						exit = true;
						System.out.println("Program Terminated");
						break;
					}
				}catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}

	}

}
