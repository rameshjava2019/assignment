package com.assignment.storeapi.model;

public class CreditResponse {
	
	String customerId;
	
	String customerName;
	
	Integer creditPoints;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCreditPoints() {
		return creditPoints;
	}

	public void setCreditPoints(Integer creditPoints) {
		this.creditPoints = creditPoints;
	}
	
	
}
