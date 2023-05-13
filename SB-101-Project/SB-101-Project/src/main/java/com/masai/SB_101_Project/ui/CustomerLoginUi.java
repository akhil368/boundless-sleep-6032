package com.masai.SB_101_Project.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.SB_101_Project.dao.CustomerSideFunctions;
import com.masai.SB_101_Project.dao.CustomerSideFunctionsImpl;
import com.masai.SB_101_Project.entity.Bill;
import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.entity.Transaction;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public class CustomerLoginUi {
//Scanner sc=new Scanner(System.in);
	
	public static void registerCustomer(Scanner  sc)
	{
		System.out.print("Enter First Name ");
		String firstName = sc.next();
		
		System.out.print("Enter Last Name ");
		String lastName = sc.next();
		
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
		
		System.out.print("Enter address ");
		String address = sc.next();
		
		System.out.print("Enter Mobile Number ");
		int number = sc.nextInt();
		
		Customer cus= new Customer(firstName, lastName, username, password, address, number, address, null, null);
		try {
			//Create an object of CustomerService
			CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
			customerService.addCustomer(cus);
			System.out.println("Customer Signed Upsuccessfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	public static void payBill(Scanner sc)
	{
		Bill b=null;
		System.out.println("Enter Bill id");
		int id=sc.nextInt();
		
		System.out.println("Enter amount");
		
		double amountPaid=sc.nextDouble();
		
		System.out.println("Enter Payment Date");
		LocalDate paymentDate=LocalDate.parse(sc.next());
		
		System.out.println("Enter Payment Method");
		String paymentMethod=sc.next();
		
		Transaction tr=new Transaction(amountPaid, paymentDate, paymentMethod);
		
		CustomerSideFunctions cs=new CustomerSideFunctionsImpl();
		try {
			cs. payBill(id,tr);
		} catch (SomethingWentWrongException | NoRecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerSideFunctions customerService = new CustomerSideFunctionsImpl();
			customerService.login(username, password);
			displayUserMenu();
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void userPannel(Scanner sc)
	{
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				AdminUI.genrateBill(sc);
    				break;
    			case 2:
    				AdminUI.showBillById(sc);
    				break;
    			case 3:
    				AdminUI.showAllBill(sc);
    				break;
    			case 4:
    				AdminUI.deleteBill(sc);
    				break;
    			case 5:
    				AdminUI.showAllPendingBill(sc);
    				break;
    			case 6:
    				AdminUI.showAllPaidBill(sc);
    				break;
    			case 7:
    				AdminUI.viewAllCustomer(sc);
    				break;
    			
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	public static void displayUserMenu() {
		System.out.println("1. change Password");
		System.out.println("2. View All Transaction");
		System.out.println("3. Pay Bill");
		System.out.println("4. Delete Account");
		
		
		System.out.println("0. Logout");
	}
	public	static void changePassword(Scanner sc) {
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
	
	public static void deleteAccount(Scanner sc) {
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
