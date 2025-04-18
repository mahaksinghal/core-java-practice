package com.app.utils;

import static com.app.core.Subject.ANGULAR;
import static com.app.core.Subject.DBT;
import static com.app.core.Subject.JAVA;
import static com.app.core.Subject.REACT;
import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

import com.app.core.Address;
import com.app.core.Student;
//import static java.util.Comparator.comparing;

public class StudentCollectionUtils {
	private static int index = 0;

	 public static List<Student> populateList() {
		
		 List<Student> students = new ArrayList<>(
				Arrays.asList(new Student("dac-001", "ravi", parse("1999-12-13"), ANGULAR, 3.2),
						new Student("dac-009", "riya", parse("1998-12-13"), REACT, 6.9),
						new Student("dac-004", "shekhar", parse("1997-12-13"), DBT, 8.9),
						new Student("dac-002", "priya", parse("1999-02-23"), JAVA, 4.7),
						new Student("dac-007", "kiran", parse("1996-02-13"), DBT, 8.1),
						new Student("dac-003", "meeta", parse("1998-12-19"), DBT, 7.9),
						new Student("dac-008", "sameer", parse("1997-12-06"), JAVA, 8.2)));
		
		List<Address> adrs = Arrays.asList(new Address("pune", "MH", "452446"), new Address("pune", "MH", "652446"),
				new Address("nagpur", "MH", "852446"), new Address("indore", "MP", "752446"),
				new Address("mumbai", "MH", "672446"), new Address("pune", "MH", "692446"),
				new Address("chennai", "TN", "862446"));

		students.forEach(s -> s.assignAddress(adrs.get(index++)));
		return students;// rets populated growable list of students with adr
	}

	// add a static method to accept list of student details & rets a map populated with the same
	public static HashMap<String, Student> populateMap(List<Student> list) {
//		HashMap<String, Student> hm = new HashMap<>();
//		list.forEach(s -> hm.put(s.getRollNo(), s));
		
		HashMap<String, Student> hm = new HashMap<>(list.stream()
				.collect(Collectors.toMap(s-> s.getRollNo(), s->s)));
		
		return hm;

	}
}
