package com.database.entities;

public class Executive {
	private int executiveId;
	private String executiveName;
	private int executiveAge;
	private String executiveAddress;
	private String executiveCity;
	private String executiveState;
	private String executivePassword;
	
	public Executive(String executiveName, int executiveAge, String executiveAddress, String executiveCity, String executiveState, String executivePassword) {
		super();
		
		this.executiveName = executiveName;
		this.executiveAge = executiveAge;
		this.executiveAddress = executiveAddress;
		this.executiveCity = executiveCity;
		this.executiveState = executiveState;
		this.executivePassword = executivePassword;
	}

	public int getExecutiveId() {
		return executiveId;
	}

	public void setExecutiveId(int executiveId) {
		this.executiveId = executiveId;
	}

	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public int getExecutiveAge() {
		return executiveAge;
	}

	public void setExecutiveAge(int executiveAge) {
		this.executiveAge = executiveAge;
	}

	public String getExecutiveAddress() {
		return executiveAddress;
	}

	public void setExecutiveAddress(String executiveAddress) {
		this.executiveAddress = executiveAddress;
	}

	public String getExecutiveCity() {
		return executiveCity;
	}

	public void setExecutiveCity(String executiveCity) {
		this.executiveCity = executiveCity;
	}

	public String getExecutiveState() {
		return executiveState;
	}

	public void setExecutiveState(String executiveState) {
		this.executiveState = executiveState;
	}

	public String getExecutivePassword() {
		return executivePassword;
	}

	public void setExecutivePassword(String executivePassword) {
		this.executivePassword = executivePassword;
	}

	
}
