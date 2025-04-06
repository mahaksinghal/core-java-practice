package com.events.core;

public class Student extends Person {
//additional state - graduation year,course,fees,marks
	private int gradYear;
	private String courseName;
	private int fees;
	private int marks;

	public Student(String firstName, String lastName, 
			int year, String course, int fees, int marks) {
		super(firstName,lastName);
		System.out.println("in student's ctor");
		this.gradYear=year;
		this.courseName=course;
		this.fees=fees;
		this.marks=marks;
	}
	//add overriding method - toString - to return COMPLETE 
	//details of the student
	@Override
	public String toString()
	{
		return "Student - " + super.toString()+" grad year"
	+this.gradYear+" course "+courseName+" fees paid "+fees+" Marks "+marks;
	}
	//additional functionality -feedback
	public void feedback() {
		//display first name of the student , course name - 
		//submitting the feedback
		System.out.println(super.getFirstName()+" submitting "
				+ "the feedback for the course "+courseName);
	}
	
	
}
