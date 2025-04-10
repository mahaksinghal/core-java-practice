package com.customer.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.customer.core.Customer;
import com.customer.core.ServicePlan;
import com.customer.custom_exception.ExceptionHandling;
import static com.customer.validations.CustomerValidations.*;
/*
 * SILVER(1000), 
	GOLD(2000), 
	DIAMOND(5000), 
	PLATINUM(10000);
 */

public class CustomerServicesImpl implements CustomerServices{
	private Map<String, Customer> customers = new HashMap<>();
	
	public CustomerServicesImpl() {
		try {
			System.out.println("Customer map created");
		signUpCustomers("a1", "b1", "a1@gmail.com", "12345", "1234567891", 1000, "2002-02-02", "silver");
		signUpCustomers("a2", "b2", "a2@gmail.com", "5e565", "1234568634", 2000, "2003-12-31", "gold");
		signUpCustomers("a3", "b3", "a3@gmail.com", "45645", "1234567896", 5000, "2001-05-27", "diamond");
		signUpCustomers("a4", "b4", "a4@gmail.com", "76524", "1234567345", 2000, "1999-08-17", "gold");
		signUpCustomers("a5", "b5", "a5@gmail.com", "345fm", "1234546789", 10000, "2005-09-15", "platinum");
		signUpCustomers("a6", "b6", "a6@gmail.com", "56u54", "3565456789", 5000, "2006-11-19", "diamond");
		
		signUpCustomers("a22", "b22", "a22@gmail.com", "16345", "1234567894", 1000, "1900-10-20", "silver");
		signUpCustomers("a33", "b33", "a33@gmail.com", "11345", "5656547342", 5000, "1994-10-20", "diamond");
		signUpCustomers("a55", "b55", "a55@gmail.com", "92345", "6756746334", 2000, "1996-02-23", "gold");
		signUpCustomers("a11", "b11", "a11@gmail.com", "12345", "6774231356", 2000, "1994-10-20", "gold");
		signUpCustomers("a44", "b44", "a44@gmail.com", "62345", "4564654524", 2000, "1994-10-20", "gold");
		signUpCustomers("a66", "b66", "a66@gmail.com", "65345", "4674523244", 1000, "1995-10-20", "silver");
		signUpCustomers("a77", "b77", "a77@gmail.com", "35345", "4562342345", 10000, "1991-10-20", "platinum");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public String signUpCustomers(String firstName, String lastName, String email, 
			String password, String phone, double regAmount, String dob, 
			String plan) throws ExceptionHandling, IllegalArgumentException {
		validateEmailPhone(email, phone);
		LocalDate date = validateDOB(dob);
		ServicePlan myPlan = validatePlan(plan, regAmount);
		Customer customer = new Customer(firstName, lastName, email, 
				password, phone, regAmount, date, myPlan);
		customers.put(email, customer);		
		return "Customer added with id: " + customer.getCustomerId();
	}
	
	@Override
	public Customer signInCustomer(String email, String password) throws ExceptionHandling {
		Customer customer = customers.get(email);
		if(customer==null)
			throw new ExceptionHandling("Invalid email");
		else
			if(!customer.getPassword().equals(password))
			throw new ExceptionHandling("Password Incorrect!!!!");
		return customer;
	}
	
	@Override 
	public void displayCustomers() {
		System.out.println("Customer Details");
		customers.values().stream().forEach(s -> System.out.println(s));
	}
	
	@Override
	public void displayCustomerBeforeSpecifiedDate(String date) throws ExceptionHandling{
		System.out.println("Customers Before the specified Date are: ");
		LocalDate dob = validateDOB(date);
		customers.values().stream()
		.filter(c -> c.getDob().isBefore(dob))
		.forEach(c -> System.out.println(c));
	}
	
	@Override
	public void UpdateCustomers() {
		customers.values().stream()
		.filter(c -> Period.between(c.getDob(), LocalDate.now()).getYears() >60)
		.filter(c -> c.getPlan().equals(ServicePlan.SILVER))
		.forEach(c -> c.setPlan(ServicePlan.GOLD));
	}
	
	@Override
	public void updatePassword(String email, String oldPassword, String newPassword) throws ExceptionHandling{
		Customer customer = signInCustomer(email, oldPassword);
		customer.setPassword(newPassword);
	}
	
	@Override
	public String unsubcribeCustomer(String email) throws ExceptionHandling {
		Customer customer = customers.remove(email);
		if(customer == null)
			throw new ExceptionHandling("No customer present with email" + email);
		return "Customer unsubscribed";
	}

	@Override
	public void removeByPlan(String plan) {
		ServicePlan myPlan = ServicePlan.valueOf(plan.toUpperCase());
		customers.values().removeIf(c -> 
		{
			if(c.getPlan().equals(myPlan))		// can also use if(c.getPlan()== myPlan)
				return true;
			else
				return false;
		}
		);
	}
	
	@Override
	public void sortByEmail() {
		TreeMap<String, Customer> custTreeMap = new TreeMap<>(customers);
		System.out.println("Sorted customers as per email");
		custTreeMap.forEach((k, v) -> System.out.println(v));
	}
	
	@Override
	public void sortByDOB() {
		System.out.println("Sorting customers as per email");
		customers.values().stream()
		.sorted((c1, c2) -> c1.getDob().compareTo(c2.getDob()))
		.forEach(c->System.out.println(c));
	}
	
	@Override
	public void sortByDobAmount() {
		System.out.println("Sorting customers as per Dob and Registration Amount");
		Comparator<Customer> comp = (c1, c2) -> {
			int retVal = c1.getDob().compareTo(c2.getDob());
			if(retVal == 0)
				return ((Double)c1.getRegAmount()).compareTo(c2.getRegAmount());
			return retVal;
		};
		
		customers.values().stream()
		.sorted(comp)
		.forEach(c -> System.out.println(c));
	}
	
	@Override
	public void sortByLastNames() {
		System.out.println("Sorting customers by their last names");
		customers.values().stream()
		.sorted((c1, c2) -> c1.getLastName().compareTo(c2.getLastName()))
		.forEach(c -> System.out.println(c));
	}
	
	@Override
	public void sortByServicePlanNames() {
		System.out.println("Sort customers by their chosen servie plans");
		customers.values().stream()
		.sorted((c1, c2) -> c1.getPlan().name().compareTo(c2.getPlan().name()))
		.forEach(c -> System.out.println(c));
	}

}













