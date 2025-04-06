package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));

		// Print sum of  marks of students of all students from the specified state
		// i/p : name of the state
		System.out.println("Enter the name of State");
		String State = sc.next();
		
		students.values()
		.stream()
		.filter(s -> s.getAddress().getState().equalsIgnoreCase(State))
		.forEach(s->System.out.println(s));
		
		
		
	}

}
