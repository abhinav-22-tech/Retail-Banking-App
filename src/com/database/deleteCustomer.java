package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.database.entities.Customer;
import com.database.helper.Helper;

public class deleteCustomer {
	
	// Delete existing data of customer
	public static void deleteCustomerAccount() throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Delete Customer Screen");
		System.out.print("Enter Customer SSNID: ");
		int customerSSID = sc.nextInt();
		sc.nextLine();
		System.out.println();

		if (!addData.checkSSNID(customerSSID)) {
			System.out.println("SSNID Not Exist");
		}

		else {
			Customer oldData = getCustomerData(customerSSID);
			System.out.println("Customer Details");

			System.out.println("Customer SSNID: " + oldData.getCustomerSSNID());
			System.out.println();

			System.out.println("Customer Name: " + oldData.getCustomerName());
			System.out.println();

			System.out.println("Customer Age: " + oldData.getCustomerAge());
			System.out.println();

			System.out.println("Customer Address: " + oldData.getCustomerAddress());
			System.out.println();

			System.out.println("Customer City: " + oldData.getCustomerCity());
			System.out.println();

			System.out.println("Customer State: " + oldData.getCustomerState());
			System.out.println();

			System.out.println("1: Confirm Delete");
			System.out.println("2: Back To Menu");

			int deletekey = sc.nextInt();
			sc.nextLine();
			if (deletekey == 1) {
				if (deleteCus(customerSSID)) {
					System.out.println("Customer delete initiated " + "successfully");
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

	// Sql query for delete the data
	public static boolean deleteCus(int SSNID) {
		try {
			boolean flag = false;
			String query = "delete from Customer where customerSSNID=?";
			PreparedStatement preparedStatement = Helper.getConnectionPreparedStatement(query);

			preparedStatement.setInt(1, SSNID);
			int temp = preparedStatement.executeUpdate();
			if (temp >= 1) {
				flag = true;
			}

			Helper.closeConnectionPreparedStatement();

			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
