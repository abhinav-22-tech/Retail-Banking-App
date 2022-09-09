package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.entities.Customer;
import com.database.helper.Helper;
import java.util.Scanner;

public class updateCustomer {

	// Update the customer details
	public static void updateCustomerAccount() throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Update Customer Screen");
		System.out.print("Enter Customer SSNID: ");
		int customerSSID = sc.nextInt();
		sc.nextLine();
		System.out.println();

		if (!addData.checkSSNID(customerSSID)) {
			System.out.println("SSNID Not Exist");
		}

		else {
			Customer oldData = getCustomerData(customerSSID);
			System.out.println("Update Customer");

			System.out.println("Customer SSNID: " + oldData.getCustomerSSNID());
			System.out.println("Customer ID: " + oldData.getCustomerId());
			System.out.println();

			System.out.println("Old Customer Name: " + oldData.getCustomerName());
			System.out.print("Enter New Customer Name: ");
			String newName = sc.nextLine();
			System.out.println();

			System.out.println("Old Customer Age: " + oldData.getCustomerAge());
			System.out.print("Enter New Customer Age: ");
			int newAge = sc.nextInt();
			sc.nextLine();
			System.out.println();

			System.out.println("Old Customer Address: " + oldData.getCustomerAddress());
			System.out.print("Enter New Customer Address: ");
			String newAddress = sc.nextLine();
			System.out.println();

			System.out.println("Old Customer City: " + oldData.getCustomerCity());
			System.out.print("Enter New Customer City: ");
			String newCity = sc.nextLine();
			System.out.println();

			System.out.println("Old Customer State: " + oldData.getCustomerState());
			System.out.print("Enter New Customer State: ");
			String newState = sc.nextLine();
			System.out.println();

			Customer newData = new Customer(oldData.getCustomerSSNID(), newName, newAge, newAddress, newCity, newState);

			System.out.println("1: Confirm Update");
			System.out.println("2: Back To Menu");

			int deletekey = sc.nextInt();
			sc.nextLine();
			if (deletekey == 1) {

				if (updateCus(newData)) {
					System.out.println("Customer update initiated " + "successfully");
				} else {
					System.out.println("Internal Error");
				}
			} else {
				try {
					MainClass.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// Get customer details 
	public static Customer getCustomerData(int SSNID) {
		try {
			String query = "select * from customer";
			PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			Customer temp = null;
			while (resultSet.next()) {
				int cSSNID = resultSet.getInt(2);
				if (SSNID == cSSNID) {
					int cid = resultSet.getInt(1);
					int cSSID = resultSet.getInt(2);
					String cName = resultSet.getString(3);
					int cAge = resultSet.getInt(4);
					String cAddress = resultSet.getString(5);
					String cCity = resultSet.getString(6);
					String cState = resultSet.getString(7);

					temp = new Customer(cid, cSSID, cName, cAge, cAddress, cCity, cState);
					return temp;
				}
			}

			Helper.closeConnectionPreparedStatement();
			return temp;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Internal Error");
		}
		return null;
	}

	// Sql query to update the customer details
	public static boolean updateCus(Customer customer) throws SQLException {
		boolean flag = false;
		String query = "update Customer set customerName=?, " + "customerAge=?, customerAddress=?, "
				+ "customerCity=?, customerState=? " + "where customerSSNID=?";
		PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);

		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setInt(2, customer.getCustomerAge());
		preparedStatement.setString(3, customer.getCustomerAddress());
		preparedStatement.setString(4, customer.getCustomerCity());
		preparedStatement.setString(5, customer.getCustomerState());
		preparedStatement.setInt(6, customer.getCustomerSSNID());

		int temp = preparedStatement.executeUpdate();
		if (temp >= 1) {
			flag = true;
		}

		Helper.closeConnectionPreparedStatement();
		return flag;
	}
}
