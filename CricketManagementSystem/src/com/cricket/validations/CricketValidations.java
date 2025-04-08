package com.cricket.validations;

import java.util.Map;
import java.util.Set;

import com.cricket.core.Cricketers;
import com.cricket.exception_handling.CustomException;

public class CricketValidations {
	public static void validateEmail(String email, Map<String, Cricketers> players) 
						throws CustomException{
		String EmailRegex = "[a-z]+[a-z0-9]+@gmail\\.(com|org|net)";
		if(!email.matches(EmailRegex))
			throw new CustomException("Invalid Email Format");
		
		if(players.containsKey(email))
			throw new CustomException("Cricketer already present");
	}
	
	public static void validatePhone(String phone) throws CustomException {
		String PhoneRegex = "\\d{10}";

		if (!phone.matches(PhoneRegex))
			throw new CustomException("Invalid Phone Number Format");
	}
	
	public static void validateAge(int age) 
			throws CustomException{
		if(age<18)
			throw new CustomException("Cricketer must be greater than 18 years");
	}
	
	public static void validateRating(int rating) 
			throws CustomException{
		if(rating >5 || rating<1)
			throw new CustomException("Cricketer rating must be between 1 and 5");
	}
	
	public static void checkEmail(String email, Set<String> emails) 
					throws CustomException {
			if(!emails.contains(email))
				throw new CustomException("email not present");
	}
	
	
	
	
	
}
