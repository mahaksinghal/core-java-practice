package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);){
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		// Print no of  failures for the specified subject chosen  from user.
		// i/p : subject name
		// (failure is GPA < 5.0 , out of 1-10)
		System.out.println("enter subject");
		Subject chosenSubject = Subject.valueOf(sc.next().toUpperCase());
		
		long count = students.values().stream()
		.filter(s->s.getSubject().equals(chosenSubject))
		.filter(s->s.getGpa()<5.0)
		.count();
		
		System.out.println("Number of students failed in the subject: " + count);
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
