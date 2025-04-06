package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import com.app.core.Student;
import com.app.core.Subject;
import com.app.custom_exception.StudentCollectionException;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);){
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
			
		// Print name of specified subject topper
		// i/p : subject name
		System.out.println("Enter subject name");
		Subject chosenSubject = Subject.valueOf(sc.next().toUpperCase());
		
		Comparator<Student> comp = (p1,p2)->((Double)p1.getGpa()).compareTo(p2.getGpa());
		
		Student maxStudent = students.values().stream()
		.filter(s->s.getSubject().equals(chosenSubject))
		.max(comp)
		.orElseThrow(() -> new StudentCollectionException("No such Student found"));
		
		System.out.println(maxStudent);
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
