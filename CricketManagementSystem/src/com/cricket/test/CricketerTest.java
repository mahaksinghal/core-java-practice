package com.cricket.test;

import java.util.Scanner;

import com.cricket.services.CricketServices;
import com.cricket.services.CricketServicesImpl;

public class CricketerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			CricketServices ops = new CricketServicesImpl();
			boolean exit = false;
			while (!exit) {
				System.out.println("Menu:\n" 
						+ "1. Add new Cricketer\n" 
						+ "2. Display All Cricketers\n"
						+ "3. Modify Cricketer's rating\n" 
						+ "4. Search Cricketer by name\n"
						+ "5. Display All Cricketers in sorted form by rating\n"
						+ "0. Exit");
				System.out.println("Enter your choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter details of cricketers:- \n"
								+ "		name, age, email_id, Phone, rating");
					 	System.out.println(ops.addCricketers(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
					 	break;
					case 2:
						ops.displayCricketers();
						break;
					case 3:
						System.out.println("Enter Cricketer's email and rating");
						ops.updateRating(sc.next(), sc.nextInt());
						break;
					case 4:
						System.out.println("Searching cricketer by name");
						System.out.println("Enter cricketer name");
						ops.searchByName(sc.next());
						break;
					case 5:
						ops.sortByRating();
						break;
					case 0: exit = true;
						System.out.println("Program terminated");
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
