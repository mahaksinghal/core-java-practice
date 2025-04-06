package com.events.core;

public class Person {
	//tight encapsulation
	private String firstName;
	private String lastName;
	public Person(String firstName,String lastName) {
		System.out.println("in person's ctor");
		this.firstName=firstName;
		this.lastName=lastName;
	}
	//override toString- to return person's details
	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
	//add a getter for the firstName
	public String getFirstName() {
		return firstName;
	}
	
	//add a getter for the lastName
	public String getLastName() {
		return lastName;
	}

}
