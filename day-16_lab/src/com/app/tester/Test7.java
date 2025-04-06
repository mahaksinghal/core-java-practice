package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Student;
import com.app.core.Subject;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);){
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		// Display  student details for specified subject , sorted as per DoB
		
		System.out.println("enter name of subject");
		Subject subject = Subject.valueOf(sc.next().toUpperCase());
		
		Comparator<Student> date = (l1, l2) -> l1.getDob().compareTo(l2.getDob());
		
		students.values().stream()
		.filter(s->s.getSubject().equals(subject))
		.forEach(s->System.out.println(date));
		
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.getStackTrace();
		}
		
	}

}
