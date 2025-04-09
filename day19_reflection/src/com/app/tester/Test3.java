package com.app.tester;

import java.util.Arrays;

import com.app.core.Emp;

public class Test3 {
	public static void main(String[] args) {
		//emp.class --> this triggers the class loading in the method area
		Class<Emp> empClass = Emp.class;
		// fields of the emp class
		System.out.println("All fields of the emp class" + empClass.getName());
		Arrays.stream(empClass.getDeclaredFields())
		.forEach(System.out::println);
		System.out.println("All constructors - ");
		Arrays.stream(empClass.getConstructors())
		.forEach(System.out::println);
		System.out.println("All methods");
		Arrays.stream(empClass.getDeclaredMethods())
		.forEach(System.out::println);
		
	}
}







