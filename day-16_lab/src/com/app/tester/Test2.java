package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		// Display  details of the students who have taken a specified subject 
		System.out.println("Enter name of specific subject taken by student");
		Subject subject_name = Subject.valueOf(sc.next().toUpperCase());
		
		students.values()
		.stream()
		.filter(s -> s.getSubject() == subject_name)
		.forEach(s -> System.out.println(s));
		
		
		
		
	}

}
