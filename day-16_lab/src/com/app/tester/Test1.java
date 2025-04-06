package com.app.tester;

import static com.app.utils.StudentCollectionUtils.populateList;
import static com.app.utils.StudentCollectionUtils.populateMap;

import java.util.HashMap;

import com.app.core.Student;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//  Display all student details from the student map.
		HashMap<String, Student> students = populateMap(populateList());
		students.values().stream().forEach(values->System.out.println(values));
		
		
	}

}
