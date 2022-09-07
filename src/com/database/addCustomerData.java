package com.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.database.entities.Customer;
import com.database.helper.Helper;

public class addCustomerData {
	public static boolean addCustomer(Customer customer) throws SQLException {
		boolean flag = false;
		String query = "insert into Customer(customerName, customerAge, customerAddress, "
				+ "customerCity, customerState, customerPassword) values (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
		
		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setInt(2, customer.getCustomerAge());
		preparedStatement.setString(3, customer.getCustomerAddress());
		preparedStatement.setString(4, customer.getCustomerCity());
		
		preparedStatement.setString(5, customer.getCustomerState());
		preparedStatement.setString(6, customer.getCustomerPassword());
		
		int temp = preparedStatement.executeUpdate();
		if(temp >= 1) {
			flag = true;
		}
		Helper.closeConnectionPreparedStatement();
		return flag;
	}
}
