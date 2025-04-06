package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);){
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		// Display names of students enrolled in a specified subject , 
		// securing marks > specified marks
		// i/p : subject name , marks
		System.out.println("enter subject");
		Subject chosenSubject = Subject.valueOf(sc.next().toUpperCase());
		System.out.println("Enter gpa");
		double gpa = sc.nextDouble();
		
		students.values().stream()
		.filter(s->s.getSubject().equals(chosenSubject))
		.filter(s->s.getGpa()>gpa)
		.forEach(s->System.out.println(s.getName()));
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
