package com.cricket.services;

import com.cricket.exception_handling.CustomException;

public interface CricketServices {
	String addCricketers(String name,int age,String email_id,String phone,int rating) 
			throws CustomException, IllegalArgumentException;
	
	void displayCricketers();
	
	void updateRating(String email, int rating) throws CustomException;
	
	void searchByName(String name);
	
	void sortByRating();
}
