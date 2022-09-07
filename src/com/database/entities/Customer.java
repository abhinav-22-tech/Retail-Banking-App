package com.database.entities;

public class Customer {
	private int customerId;
	private String customerName;
	private int customerAge;
	private String customerAddress;
	private String customerCity;
	private String customerState;
	
	public Customer(int ssn_Id, String customerName, int customerAge, String customerAddress, String customerCity,
			String customerState) {
		super();
		this.customerId = ssn_Id;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerAddress = customerAddress;
		this.customerCity = customerCity;
		this.customerState = customerState;
	}

	public int getSsn_Id() {
		return customerId;
	}

	public void setSsn_Id(int ssn_Id) {
		this.customerId = ssn_Id;
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


