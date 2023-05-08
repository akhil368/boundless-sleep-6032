package com.masai.SB_101_Project.dao;

import java.util.List;

import com.masai.SB_101_Project.entity.Customer;
import com.masai.SB_101_Project.exceptions.NoRecordFound;
import com.masai.SB_101_Project.exceptions.SomethingWentWrongException;

public interface CustomerSideFunctions {
	public void addCustomer(Customer customer) throws SomethingWentWrongException ;
	void login(String username, String password) throws SomethingWentWrongException;
	void changePassword(String oldPassword, String newPassword) throws SomethingWentWrongException;
	void deleteAccount() throws SomethingWentWrongException;
	public void payBill();
	public void viewAllTransactionHistory();
	
	List<Object[] > getCustomerList() throws SomethingWentWrongException,NoRecordFound;
}