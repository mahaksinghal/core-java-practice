package com.cms.service;

import com.cms.core.Customer;
import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;
import static com.cms.validations.CMSValidations.parseValidatePlanAndRegAmount;

import java.time.LocalDate;

public class CMSOperationsImpl implements CMSOperations{
	// create customer array and add a counter 
	private Customer[] customers;
	private int counter;
	
	// add a constructor
	public CMSOperationsImpl(int size) {
		this.customers = new Customer[size];
	}
	
	@Override
	public String registerCustomer(String firstName, String lastName, String email, 
			String password, double regAmt, String dob, String plan)
				throws CMSException, IllegalArgumentException
	{
		// invoke validation rule
		ServicePlan myPlan = parseValidatePlanAndRegAmount(plan, regAmt);
		// parse DOB
		LocalDate date = LocalDate.parse(dob);
		Customer c = new Customer(firstName, lastName, email, password, regAmt, date, myPlan);
		customers[counter++] = c;
		return "Customer registration successfull";
	}
	
//	@Override
//	public void displayCustomers() {
//		for(Customer c: customers)
//			if(c!=null) {
//			System.out.println("Id:" + c.getCustomerId() +
//			"\nName: " + c.getName() + 
//			"\nEmail: " + c.getEmail() +
//			"\nPlan: " + c.getPlan() + 
//			"\nDate of birth: " + c.getDate());
//			}
	
	@Override
	public String authenticate(String email, String password) throws CMSException {
		// find the customer by its email
		// in case of success - customer ref else throw exception
		Customer customer = findByEmail(email);
		// customer is valid ----> check password
		if(customer.getPassword().equals(password))
			return "Login successfull!!!!!!! Hello " + customer.getName();
		throw new CMSException("Invalid Password........Try Again");
	}
	
	public Customer findByEmail(String email) throws CMSException {
		Customer cust = new Customer(email);
		for(Customer c: customers) {
			if(c != null) {
				if(c.equals(cust))
					return c;
			}
		}
		throw new CMSException("Invalid Email.......Please type correct email");
	}
}






















