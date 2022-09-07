package com.database;

import java.util.Scanner;

import com.database.helper.BaseQuery;

import com.database.entities.Customer;

public class MainClass {
	public static void main(String[] args) throws Exception {
//		BaseQuery.makeTable(false);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("1: Login");
		System.out.println("2: Create New Account");
		
		int key = sc.nextInt();sc.nextLine();
		if(key == 1) {
//			loginUser();
			
		}
		else if(key == 2) {
			System.out.println("Select Account!");
			System.out.println("1: Customer Account");
			System.out.println("1: Executive Account");
			
			System.out.print("Enter Your Name: ");
			String customerName = sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your Age: ");
			int customerAge = sc.nextInt();sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your Address: ");
			String customerAddress = sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your City: ");
			String customerCity = sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your State: ");
			String customerState = sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your Password(must be alpanumaric): ");
			String customerPassword = sc.nextLine();
			System.out.println();
			
			Customer customer = new Customer(customerName, customerAge, 
					customerAddress, customerCity, customerState, customerPassword);
			
			if(addCustomerData.addCustomer(customer)) {
				System.out.println("Customer creation initiated "
						+ "successfully");
			}
		}
	}
}
