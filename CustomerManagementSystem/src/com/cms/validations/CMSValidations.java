package com.cms.validations;

import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSValidations {
	// add public static method to parse and validate plan it's reg Amount
	public static ServicePlan parseValidatePlanAndRegAmount(String plan, double amount)
	throws IllegalArgumentException, CMSException
	{
		// parsing from String to enum ----> JVM will throw system exception ----> valueOf
		ServicePlan myPlan = ServicePlan.valueOf(plan.toUpperCase());
		
		// check plan and amount - in case of error ----> throw custom exception
		if(myPlan.getPlanCost() != amount)
			throw new CMSException("Registration Amount doesn't match with the chosen plan");
		return myPlan;
	}
}
