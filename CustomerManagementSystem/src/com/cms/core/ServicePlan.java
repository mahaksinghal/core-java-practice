package com.cms.core;

public enum ServicePlan {
	SILVER(1000), 
	GOLD(2000), 
	DIAMOND(5000), 
	PLATINUM(10000);
	
	// add a field
	private double planCost;

	private ServicePlan(double planCost) {
		this.planCost = planCost;
	}
	
	public double getPlanCost() {
		return this.planCost; 
	}
}
