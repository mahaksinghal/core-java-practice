package com.events.core;

public class Faculty extends Person {
	private int expInYears;
	private String sme;
	public Faculty(String fn,String ln,int yrs,String sme) {
		super(fn,ln);
		System.out.println("in faculty ctor");
		this.expInYears=yrs;
		this.sme=sme;
	}
	/*
	 * add overriding method - toString - to return 
	 * COMPLETE 	details of the Faculty
	 */
	@Override
	public String toString() {
		return "Faculty "+super.toString()
		+" exp in years "+expInYears+" expert in "+sme;
	}
	/*
	 * display last name of the faculty , evaluating the students in sme
	 */
	public void evaluateStudents() {
		System.out.println(getLastName()+" evaluating the students ,"
				+ " for domains -"+sme);
	}
}
