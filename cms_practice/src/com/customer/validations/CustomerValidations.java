package com.customer.validations;

import java.time.LocalDate;
import java.time.Period;

import com.customer.core.ServicePlan;
import com.customer.custom_exception.ExceptionHandling;

public class CustomerValidations {
	
	public static void validateEmailPhone(String email, String phone) throws ExceptionHandling{
		String emailRegex = "[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		String phoneRegex = "\\d{10}";
		
		if(!email.matches(emailRegex))
			throw new ExceptionHandling("Invalid email format");
		if(!phone.matches(phoneRegex))
			throw new ExceptionHandling("Invalid phone number");		
	}
	
	public static LocalDate validateDOB(String dob) throws ExceptionHandling {
		LocalDate date = LocalDate.parse(dob);
		int age = Period.between(date, LocalDate.now()).getYears();
		if(age<18)
			throw new ExceptionHandling("Age must be greater than 18");
		else
			return date;
	}
	
	public static ServicePlan validatePlan(String plan, double regAmount) throws ExceptionHandling {
		ServicePlan myPlan = ServicePlan.valueOf(plan.toUpperCase());
		if(myPlan.getPlanCost()!=regAmount)
			throw new ExceptionHandling("Registration amount should match the selected plan");
		else
			return myPlan;
	}
	
	

}
