package com.database.entities;

public class Customer {
	private int customerId;
	private String customerName;
	private int customerAge;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	
	public Customer(int customerId, String customerName, int customerAge, 
			String customerAddress, String customerCity, 
			String customerState) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
	}
	
	public Customer(String customerName, int customerAge, 
			String customerAddress, String customerCity, 
			String customerState) {
		super();
		
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}
}


