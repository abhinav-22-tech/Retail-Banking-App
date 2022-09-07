package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.database.entities.*;
import com.database.helper.Helper;

public class displayData {
	public static void getCustomer() throws SQLException{
		ArrayList<Customer> customer = new ArrayList<Customer>();
		String query = "select * from Customer";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			int cid = resultSet.getInt(1);
			String cName = resultSet.getString(2);
			int cAge = resultSet.getInt(3);
			String cAddress = resultSet.getString(4);
			String cCity = resultSet.getString(5);
			String cState = resultSet.getString(6);
			
			Customer temp = new Customer(cid, cName, cAge
					, cAddress, cCity, cState);
			customer.add(temp);
		}
		
		Helper.closeConnectionPreparedStatement();
		
		for(int i = 0; i < customer.size(); i++) {
			Customer cus = customer.get(i);
			System.out.println("Customer Id: " + cus.getCustomerId());
			System.out.println("Customer Name: " + cus.getCustomerName());
			System.out.println("Customer Age: " + cus.getCustomerAge());
			System.out.println("Customer Address: " + cus.getCustomerAddress());
			System.out.println("Customer City: " + cus.getCustomerCity());
			System.out.println("Customer State: " + cus.getCustomerState());
		}
	}
	
	public static void getExecutive() throws SQLException{
		ArrayList<Executive> executive = new ArrayList<Executive>();
		String query = "select * from Executive";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			int eid = resultSet.getInt(1);
			String eName = resultSet.getString(2);
			String eUserName = resultSet.getString(3);
			int eAge = resultSet.getInt(4);
			String eAddress = resultSet.getString(5);
			String eCity = resultSet.getString(6);
			String eState = resultSet.getString(7);
			
			Executive temp = new Executive(eid, eName, eUserName,eAge
					, eAddress, eCity, eState);
			executive.add(temp);
		}
		
		Helper.closeConnectionPreparedStatement();
		
		for(int i = 0; i < executive.size(); i++) {
			Executive exec = executive.get(i);
			System.out.println("Customer Id: " + exec.getExecutiveId());
			System.out.println("Customer Name: " + exec.getExecutiveName());
			System.out.println("Customer UserName: " + exec.getExecutiveUserName());
			System.out.println("Customer Age: " + exec.getExecutiveAge());
			System.out.println("Customer Address: " + exec.getExecutiveAddress());
			System.out.println("Customer City: " + exec.getExecutiveCity());
			System.out.println("Customer State: " + exec.getExecutiveState());
		}
	}
}
