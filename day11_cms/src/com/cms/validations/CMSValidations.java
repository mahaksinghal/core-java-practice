package com.cms.validations;

import java.time.LocalDate;
import java.util.List;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSValidations {
//add public static method to parse and validate plan it's reg amount
	public static ServicePlan parsePlan(String plan)
			throws IllegalArgumentException {
		// 1. parsing (string -> enum, valueOf)
		return ServicePlan.valueOf(plan.toUpperCase());

	}

	public static void validatePlan(ServicePlan myPlan, 
			double amount)
			throws CMSException {
			// To check plan n reg amount
		if (myPlan.getPlanCost() != amount)
			throw new CMSException("Reg amount doesn't match " + "with the chosen plan !!!!");
		
	}

	// add validation rule for email
	public static void validateEmail(String email, List<Customer> customerList) throws CMSException {
		// check for well formed email
		String regEx = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		if (!email.matches(regEx))
			throw new CMSException("Invalid email format !!!!!!!!!!!!");
		// => well formed email , chk for dup
		Customer c = new Customer(email);
		if (customerList.contains(c))	// internally calling ----> c.equals(c1)
			throw new CMSException("Dup email id !!!!!!!!");
	}

	// add a method for parsing the date (string -> localdate)
	public static LocalDate parseDob(String date) {
		return LocalDate.parse(date);
	}
}
