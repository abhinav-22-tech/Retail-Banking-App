package com.database;

import java.util.ArrayList;
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
			System.out.print("Enter Your Username: ");
			String inputUserName = sc.nextLine();
			System.out.println();
			
			System.out.print("Enter Your Password: ");
			String inputPassword = sc.nextLine();
			System.out.println();
			
			if(loginUser.checkUsernamePassword(inputUserName, inputPassword)) {
				System.out.println("Login Successfully");
			}
			else {
				System.out.println("Enter Valid Username And Password");
			}
			displayData.getExecutive();
		}
		else if(key == 2) {
			System.out.println("Select Account!");
			System.out.println("1: Customer Account");
			System.out.println("2: Executive Account");
			
			int accountKey = sc.nextInt();sc.nextLine();
			if(accountKey == 1) {
				addData.addCustomerAccount();
			}
			else if(accountKey == 2) {
				addData.addExecutiveAccount();
			}
		}
	}
}
