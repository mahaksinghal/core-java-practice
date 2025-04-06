package com.events.tester;

import java.util.Scanner;
import com.events.core.*;

public class EventOrganizer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter event capacity");
		// create a data structure
		Person[] participants = new Person[sc.nextInt()];
		boolean exit = false;
		int counter = 0;
		while (!exit) {
			System.out.println("Options - 1. Register Stundent \n" + "2. Register Faculty\n"
					+ "3. Display all participants\n" + "4. Display specific participant by Seat no\n"
					+ "5. Display sub class specific functionality by Seat no\n" + "0. Exit");
			System.out.println("Choose option-");
			switch (sc.nextInt()) {
			case 1: // register a student
				if (counter < participants.length) {
					System.out.println(
							"Enter student details -firstName,  lastName," + "grad year,  course,  fees,  marks");
					participants[counter] = new Student(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.nextInt(),
							sc.nextInt());// up casting
					counter++;
					System.out.println("Student registered...");
				} else
					System.out.println("Event Full !");

				break;
			case 2: // faculty registration
				if (counter < participants.length) {
					System.out.println("Enter faculty details -firstName,  lastName," + "experience sme");
					participants[counter] = new Faculty(sc.next(), sc.next(), sc.nextInt(), sc.next());// up casting
					counter++;
					System.out.println("Faculty registered...");
				} else
					System.out.println("Event Full !");

				break;
			case 3:
				System.out.println("Event Participants-");
				// {s1,s2,s3,f1,f2,s4,s5.......}
				for (Person p : participants)// p=participants[0].....
				{
					if (p != null) {
						System.out.println(p);// p.toString() - run time poly.
					}
				}
				break;
			case 4:
				System.out.println("Enter seat no");
				int index = sc.nextInt() - 1;
				if (index >= 0 && index < counter) {
					System.out.println(participants[index]);// run time poly=D.M.D
				} else
					System.out.println("Invalid seat no !!!!!!!!!!!!");
				break;
			case 5:
				System.out.println("Enter seat no for sub class specific func");
				index = sc.nextInt() - 1;
				Person person=participants[index];
				// {s1,s2,s3,f1,f2,s4,s5.......}
				if (index >= 0 && index < counter) {
					if (person instanceof Student)
					 ((Student)person).feedback();
					else if(person instanceof Faculty){
						((Faculty)person).evaluateStudents();
					}
				} else
					System.out.println("Invalid seat no !!!!!!!!!!!!");
				break;
			case 0:
				exit = true;
				break;
			}
		}
		sc.close();

	}

}
