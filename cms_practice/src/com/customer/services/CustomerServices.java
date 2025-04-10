package com.customer.services;

import com.customer.core.Customer;
import com.customer.custom_exception.ExceptionHandling;

public interface CustomerServices {
	
	String signUpCustomers(String firstName, String lastName, String email, 
			String password, String phone, double regAmount, String dob, 
			String plan) throws ExceptionHandling, IllegalArgumentException;
	
	Customer signInCustomer(String email, String password) throws ExceptionHandling;
	
	void displayCustomers();
	
	void displayCustomerBeforeSpecifiedDate(String date) throws ExceptionHandling;
	
	void UpdateCustomers();
	
	void updatePassword(String email, String oldPassword, String newPassword) throws ExceptionHandling;
	
	String unsubcribeCustomer(String email) throws ExceptionHandling;
	
	void removeByPlan(String plan);
	
	void sortByEmail();
	
	void sortByDOB();
	
	void sortByDobAmount();
	
	void sortByLastNames();
	
	void sortByServicePlanNames();
}
