package com.app.tester;

import com.app.fruits.*;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the capacity");
		Fruit[] fruits = new Fruit[sc.nextInt()];
		int counter = 0;
		boolean exit = false;
		while (!exit) {
			System.out.println("Menu:\n" + "1. Add Alphonso\n" + "2. Add Orange\n" + "3. Add Apple\n"
					+ "4. Display Names of all fruits in the basket\n"
					+ "5. Display All Properties availabe in the basket\n" + "6. Invoke Special Functionality\n"
					+ "7. Exit\n");
			System.out.println("Choose Option: ");
			switch (sc.nextInt()) {
			case 1:
				if (fruits.length > counter) {
					System.out.println("Enter name, color, weight of the fruit");
					fruits[counter] = new Alphonso(sc.next(), sc.next(), sc.nextDouble());
					counter++;
					System.out.println("Alphonso Fruit Added");
				} else {
					System.out.println("Basket Full");
				}
				break;
			case 2:
				if (fruits.length > counter) {
					System.out.println("Enter name, color, weight, of the fruit");
					fruits[counter] = new Orange(sc.next(), sc.next(), sc.nextDouble());
					counter++;
					System.out.println("Orange Fruit Added");
				} else {
					System.out.println("Basket Full");
				}
				break;
			case 3:
				if (fruits.length > counter) {
					System.out.println("Enter name, color, weight");
					fruits[counter] = new Apple(sc.next(), sc.next(), sc.nextDouble());
					System.out.println("Apple Fruit Added");
				} else {
					System.out.println("Basket Full");
				}
				break;
			case 4:
				System.out.println("All Fruit Names");
				for (Fruit f : fruits) {
					if (f != null) {
						System.out.println(f.getName());
					}
				}
				break;
			case 5:
				System.out.println("Displaying all properties in basket");
				for (Fruit f : fruits) {
					if (f != null) {
						System.out.println(f);
						System.out.println(f.taste());
					}
				}
				break;
			case 6:
				System.out.println("Enter the fruit number in the basket");
				int index = sc.nextInt() - 1;
				Fruit f = fruits[index];
				if (index > 0 && index < counter) {
					if (f instanceof Apple) {
						((Apple) f).jam();
					} else if (f instanceof Alphonso) {
						((Alphonso) f).pulp();
					} else {
						((Orange) f).juice();
					}
				} else {
					System.out.println("Out of Index");
				}
				break;
			case 7:
				System.out.println("Exiting");
				exit = true;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

		sc.close();
	}

}
