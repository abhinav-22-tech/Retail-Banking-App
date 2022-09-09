package com.database;

import java.util.Scanner;
import java.sql.SQLException;

public class MainClass {
	static String inputUserName = null;
	static String inputPassword = null;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// Check already login or not
		if (inputUserName == null || inputPassword == null) {
			System.out.println("Login!");
			System.out.print("Enter Your Username: ");
			inputUserName = sc.nextLine();
			System.out.println();

			System.out.print("Enter Your Password: ");
			inputPassword = sc.nextLine();
			System.out.println();

			// verify user name and password
			if (loginUser.checkUsernamePassword(inputUserName, inputPassword)) {
				System.out.println("Login Successfully");
				menu();

			} else {
				System.out.println("Enter Valid Username And Password");
			}
		}

		else {
			menu();
		}

	}

	// Main menu of retail banking customer executive
	public static void menu() throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Menu");
			System.out.println("1: Create Customer");
			System.out.println("2: Update Customer");
			System.out.println("3: Delete Customer");

			int accountKey = sc.nextInt();
			sc.nextLine();
			if (accountKey == 1) {
				// Create New Customer
				addData.addCustomerAccount();
				menu();
			} else if (accountKey == 2) {
				// Update Customer Data
				updateCustomer.updateCustomerAccount();
				menu();
			} else if (accountKey == 3) {
				// Delete Customer Data
				deleteCustomer.deleteCustomerAccount();
				menu();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Enter Valid Key");
			MainClass.main(null);
		}
	}
}
