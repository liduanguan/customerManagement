package com.liduan.customerManagement.service;

import com.liduan.cusomterManagement.bean.Customer;

/**
 * @description Array of Customer Object 
 * @author Liduan Guan	Email: guane@uwindnsor.ca
 * @version
 * @date Aug 11, 2021
 */

public class CustomerList {
	private Customer[] customers;
	private int total = 0;
	
	/**
	 * constructor to initialize customers array
	 * @param totalCustomer: set length of array
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	/**
	 * @description return all the customers
	 * @return Customer[]
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i = 0; i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}


	/**
	 * @description get number of customers
	 * @return total
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * @description get a customer with an index
	 * @param index
	 * @return Customer, or null if not not found
	 */
	public Customer getCustomer(int index) {
		if( index < 0 || index >= total ) {
			return null;
		}
		return customers[index];
	}
	
	/**
	 * @description add a Customer to the customers array
	 * @param customer
	 * @return true: add success  false: add failure
	 */
	public boolean addCumstoer(Customer customer) {
		if( total >= customers.length) {
			return false;
		}
		 customers[total++] = customer;	 
		 return true;
	}
	
	/**
	 * @description modify a customer with index
	 * @param index
	 * @param cust
	 * @return true: modify success false: modify failure
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if( index < 0 || index >= total ) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	
	/**
	 * @description delete a customer with index
	 * @param index
	 * @return true: delete success; false: delete failure
	 */
	public boolean deleteCustomer(int index) {
		if( index < 0 || index >= total) {
			return false;
		}
		for( int i = index; i < total; i++) {
			customers[ i ] = customers[i + 1];		
		}
		// last element set to null
		customers[total--] = null;
		return true;
	}
}
