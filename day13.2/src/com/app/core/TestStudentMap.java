package com.app.core;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestStudentMap {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// create empty HashMap to store student details - init capa =128
			HashMap<String, Student> students = new HashMap<>(128);
			System.out.println(students);// {}

			// populate the map
			System.out.println("rets " + students.put("dac-0009", new Student("dac-0009", "Mohan", 80)));
			System.out.println("rets " + students.put("dac-0024", new Student("dac-0024", "Samay", 72)));
			System.out.println("rets " + students.put("dac-0031", new Student("dac-0031", "Kiran", 85)));
			System.out.println("rets " + students.put("dac-0015", new Student("dac-0015", "Divya", 76)));
			System.out.println("rets " + students.put("dac-0010", new Student("dac-00010", "Mihir", 70)));
			System.out.println("rets " + students.putIfAbsent("dac-0019", new Student("dac-0019", "Abha", 71)));
			// System.out.println(students);

			// display student details - on separate lines
			System.out.println("All students - ");
			for (Student s : students.values())// Collection<Student>
				System.out.println(s);

			// displaying the student details by searching the key---->rollNo
//			System.out.println("Enter the roll no");
//			String index = sc.next();
//			Student student = students.get(index);
//			if(student != null)
//				System.out.println("the student details are"+student);
//			else
//				System.out.println("Invalid Roll Number");

			// remove the student details based upon user input of roll number
//			System.out.println("Enter the roll number you want to delete");
//			String index1 = sc.next();
//			if(students.remove(index1)!=null)
//				System.out.println("Student Removed");
//			else
//				System.out.println("Deletion failed");

			// update student marks based upon their roll number
//			System.out.println("Enter roll number of student, marks u want to update");
//			String index = sc.next();
//			Student student = students.get(index);
//			
//			if(student!=null){
//				System.out.println("\nEnter the updated marks \n");
//				int marks = sc.nextInt();
//				student.setMarks(marks);
//			}else {
//				System.out.println("Student not found");
//			}
			
			// display all students names with marks greater than specified marks
//			System.out.println("Enter the marks");
//			int marks = sc.nextInt();
//			for(Student s: students.values()) {
//				if(s.getMarks()>marks)
//					System.out.println(s.getName());
//			}
			
			// Sort student details as per roll no
//			TreeMap<String, Student> TreeMapStudents = new TreeMap<>();
//			TreeMapStudents.putAll(students);
			// --------or--------
//			TreeMap<String, Student> TreeMapStudents = new TreeMap<>(students);
			// display student details - on separate lines
//			System.out.println("All students - ");
//			for (Student s : TreeMapStudents.values())// Collection<Student>
//				System.out.println(s);
			
			//  Sort student details as per names
			System.out.println("Sorting based on names: ");
			
			TreeMap<String, Student> sortByName = new TreeMap<>(new Comparator<String>() {
				@Override
				public int compare(String rollNo1, String rollNo2) {
					System.out.println("in compare");
					return students.get(rollNo1).getName().compareTo(students.get(rollNo2).getName());
				}
			});
			// display student details - on separate lines
			System.out.println("All students - ");
			for (Student s : sortByName.values())// Collection<Student>
				System.out.println(s);
			
			
		}
	}
}






















