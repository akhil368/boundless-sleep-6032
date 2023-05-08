package com.masai.SB_101_Project.ui;

import java.util.Scanner;

import com.masai.SB_101_Project.dao.CustomerSideFunctions;
import com.masai.SB_101_Project.dao.CustomerSideFunctionsImpl;
import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public class CustomerLoginUi {
//Scanner sc=new Scanner(System.in);
	
	static void registerCustomer(Scanner  sc)
	{
		System.out.print("Enter First Name ");
		String firstName = sc.next();
		
		System.out.print("Enter Last Name ");
		String lastName = sc.next();
		
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		
		System.out.print("Enter address");
		String address = sc.nextLine();
		
		System.out.print("Enter password ");
		int number = sc.nextInt();
		
		Customer cus= new Customer(firstName, lastName, username, password, address, number, address, null, null);
		try {
			//Create an object of CustomerService
			CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
			customerService.addCustomer(cus);
			System.out.println("Customer added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
//		try {
//			CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
//			customerService.login(username, password);
////			userMenu(sc);
//		}catch(NoRecordFound | SomethingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
	}
	static void changePassword(Scanner sc) {
		System.out.print("Enter old password ");
		String oldPassword = sc.next();
		System.out.print("Enter new password ");
		String newPassword = sc.next();
		System.out.print("Re-Enter new password ");
		String reEnterNewPassword = sc.next();
		
		//Check if new password is correct
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println("New password and Re-Entered password mismtached");
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println("New password and old password must be different");
			return;
		}
		
		try {
			CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
			customerService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println("Password updated");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void deleteAccount(Scanner sc) {
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
				customerService.deleteAccount();
				System.out.println("Its really sad to see you go, As per your request account is deleted");			
			}catch(SomethingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}