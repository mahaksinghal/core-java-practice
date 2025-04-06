package com.events.tester;

import com.events.core.*;

public class TestCtorInvocation {

	public static void main(String[] args) {
		// Student
		Student s1 =
				new Student("a1", "b1", 2023, "DAC", 123456, 78);
		// Faculty
		Faculty f1 = 
				new Faculty("a2", "b2", 10, "Java , React Mongo DB");

	}

}
