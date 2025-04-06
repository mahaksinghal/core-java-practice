package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Student;
import com.app.core.Subject;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);){
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		// Suppose a subject faculty is unavailable n then subject is cancelled . 
		// Collect the specified subject students into the list n display it.
		// i/p : subject name
		
		System.out.println("enter name of subject");
		Subject subject = Subject.valueOf(sc.next().toUpperCase());
		List<Student> listOfStudents = students.values().stream()
		.filter(s->s.getSubject().equals(subject))
		.collect(Collectors.toList());
		
		listOfStudents.stream().forEach(s->System.out.println(s));
		
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
