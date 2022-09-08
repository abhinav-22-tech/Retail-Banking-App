package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.entities.*;

import com.database.helper.Helper;
import java.util.Scanner;


public class addData {
	
	public static void addCustomerAccount() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Add Customer Account");
		System.out.print("Enter Customer SSNID: ");
		int customerSSID = sc.nextInt();sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Customer Name: ");
		String customerName = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Customer Age: ");
		int customerAge = sc.nextInt();sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Customer Address: ");
		String customerAddress = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Customer City: ");
		String customerCity = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Customer State: ");
		String customerState = sc.nextLine();
		System.out.println();
		
		Customer customer = new Customer(customerSSID,customerName, customerAge, 
				customerAddress, customerCity, customerState);
		
		if(checkSSNID(customerSSID)) {
			System.out.println("SSNID Already Exist");
		}
		else if(addData.addCustomer(customer)) {
			System.out.println("Customer creation initiated "
					+ "successfully");
		}
	}
	
	public static boolean checkSSNID(int SSNID) {
		try {
			String query = "select * from customer";
			PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int cSSNID = resultSet.getInt(2);
				if(SSNID == cSSNID) {
					return true;
				}
			}
			Helper.closeConnectionPreparedStatement();
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Error");
		}
		return false;
	}
	
	public static boolean addCustomer(Customer customer) throws SQLException {
		boolean flag = false;
		String query = "insert into Customer(customerSSNID, customerName, "
				+ "customerAge, customerAddress, "
				+ "customerCity, customerState) values (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		preparedStatement.setInt(1, customer.getCustomerSSNID());
		preparedStatement.setString(2, customer.getCustomerName());
		preparedStatement.setInt(3, customer.getCustomerAge());
		preparedStatement.setString(4, customer.getCustomerAddress());
		preparedStatement.setString(5, customer.getCustomerCity());
		
		preparedStatement.setString(6, customer.getCustomerState());
		
		int temp = preparedStatement.executeUpdate();
		if(temp >= 1) {
			flag = true;
		}
		Helper.closeConnectionPreparedStatement();
		return flag;
	}
	
	public static void addExecutiveAccount() throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Executive Account");
		System.out.print("Enter Your Name: ");
		String executivName = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your Username: ");
		String executivUserName = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your Age: ");
		int executivAge = sc.nextInt();sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your Address: ");
		String executivAddress = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your City: ");
		String executivCity = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your State: ");
		String executivState = sc.nextLine();
		System.out.println();
		
		System.out.print("Enter Your Password(must be alpanumaric): ");
		String executivPassword = sc.nextLine();
		System.out.println();
		
		Executive executive = new Executive(executivName, executivUserName, executivAge, 
				executivAddress, executivCity, executivState, executivPassword);
		
		if(addData.addExecutive(executive)) {
			System.out.println("Executive creation initiated "
					+ "successfully");
		}
	}
	
	public static boolean addExecutive(Executive executive) throws SQLException {
		boolean flag = false;
		String query = "insert into Executive(executiveName, executiveUserName, executiveAge, executiveAddress, "
				+ "executiveCity, executiveState, executivePassword) values (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		preparedStatement.setString(1, executive.getExecutiveName());
		preparedStatement.setString(2, executive.getExecutiveUserName());
		preparedStatement.setInt(3, executive.getExecutiveAge());
		preparedStatement.setString(4, executive.getExecutiveAddress());
		preparedStatement.setString(5, executive.getExecutiveCity());
		
		preparedStatement.setString(6, executive.getExecutiveState());
		preparedStatement.setString(7, executive.getExecutivePassword());
		
		int temp = preparedStatement.executeUpdate();
		if(temp >= 1) {
			flag = true;
		}
		Helper.closeConnectionPreparedStatement();
		return flag;
	}
}
