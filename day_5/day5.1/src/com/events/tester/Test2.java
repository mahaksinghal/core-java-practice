package com.events.tester;

import com.events.core.Faculty;
import com.events.core.Person;
import com.events.core.Student;

public class Test2 {

	public static void main(String[] args) {
		Person p;// super class reference
		// can a super class reference , refer to ANY sub class object?
		// YES - up casting
		p = new Student("a1", "b1", 2023, "DAC", 123456, 78);//up casting
	//	System.out.println(p.getDetails());//run time poly - D.M.D
		System.out.println(p);//Student- fn ln
		p=new Faculty("a2", "b2", 10, "Java , React Mongo DB");//up casting
//		System.out.println(p.getDetails());//run time poly - D.M.D
		System.out.println(p);//Faculty - fn ln
	}

}
