package com.liduan.customerManagement.view;

import com.liduan.cusomterManagement.bean.Customer;
import com.liduan.customerManagement.service.CustomerList;
import com.liduan.customerManagement.util.CMUtility;

public class CustomerView {
	private CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer cust = new Customer("jack", 'M', 30, "010-56253825", "abc@email.com");
		customerList.addCumstoer(cust);
	}

	public void enterMainMenu() {
		boolean isFlag = true;
		do {
			System.out.println("\n------------------Customer Information Management System------------------");
			System.out.println("                    1 Add Customer");
			System.out.println("                    2 Modify Customer");
			System.out.println("                    3 Delete Customer");
			System.out.println("                    4 Customer Information");
			System.out.println("                    5 Exit");
			System.out.println("                    Please Selcet(1-5)");

			char menu = CMUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomer();
				break;
			case '5':
				System.out.println("Do you want to quit?(Y/N)");
				char isExit = CMUtility.readConfirmSelection();
				if (isExit == 'Y') {
					isFlag = false;
				}
			}

		} while (isFlag);
	}

	/**
	 * @description add a cusomter
	 */
	private void addNewCustomer() {
		System.out.println("Name:");
		String name = CMUtility.readString(30);
		System.out.println("Gender:");
		char gender = CMUtility.readChar();
		System.out.println("Age:");
		int age = CMUtility.readInt();
		System.out.println("Phone Number:");
		String phone = CMUtility.readString(13);
		System.out.println("Email Address:");
		String email = CMUtility.readString(30);

		Customer customer = new Customer(name, gender, age, phone, email);
		boolean isSuccess = customerList.addCumstoer(customer);
		if (isSuccess) {
			System.out.println("------------------Add Success------------------");
		} else {
			System.out.println("------------------Add fail------------------");
		}
	}

	/**
	 * @description modify a customer
	 */
	private void modifyCustomer() {
		for (;;) {
			System.out.println("Please input a customer number(-1 to quit): ");
			int customerNumber = CMUtility.readInt();
			if (customerNumber == -1) {
				return;
			} else if (customerNumber > 0 && customerNumber <= customerList.getTotal()) {
				Customer cust = customerList.getCustomer(customerNumber-1);
				System.out.println("Name(" + cust.getName() + ") :");
				String name = CMUtility.readString(30,cust.getName());
				System.out.println("Gender(" + cust.getGender() + ") :");
				char gender = CMUtility.readChar(cust.getGender());
				System.out.println("Age(" + cust.getAge() + ") :");
				int age = CMUtility.readInt(cust.getAge());
				System.out.println("Phone(" + cust.getPhone() + ") :");
				String phone = CMUtility.readString(13,cust.getPhone());
				System.out.println("Email Address(" + cust.getEmail() + ") :");
				String email = CMUtility.readString(30,cust.getEmail());
				
				Customer customer = new Customer(name, gender, age, phone, email);
				boolean isSuccess = customerList.replaceCustomer(customerNumber - 1, customer);
				if (isSuccess) {
					System.out.println("------------------Change Success------------------");
				} else {
					System.out.println("------------------Change Fail------------------");
				}

			} else {
				System.out.println("Customer does not exist. Plesse input a valid customer number(-1 to quit):");
				break;
			}
		}
	}

	/**
	 * @description delete a customer
	 */
	private void deleteCustomer() {
		System.out.println("\n------------------Delete Customer------------------");
		int customerNumber;
		while(true) {
			System.out.println("Please input the idex to be delete(-1 to quit):");
			customerNumber = CMUtility.readInt();
			if(customerNumber == -1) {
				return;
			}
			Customer customer = customerList.getCustomer(customerNumber - 1);
			if(customer == null) {
				System.out.println("Customer does not exist.");
			}else {
				break;
			}		
		}
		System.out.println("Are you sure to delete?");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete == 'Y') {
			customerList.deleteCustomer(customerNumber - 1);
		}
	}

	/**
	 * @description print all customer
	 */
	private void listAllCustomer() {

		if (customerList.getTotal() == 0) {
			System.out.println("No customer data!");
		} else {
			System.out.println("\n------------------Customer List------------------");
			System.out.println("Number\tName\tGender\tAge\tTel\tEmail Address");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				System.out.println((i + 1) + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t"
						+ custs[i].getAge() + "\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
			}
			System.out.println("\n------------------Customer List Complete------------------");
		}
	}

	public static void main(String[] args) {
		CustomerView customerView = new CustomerView();
		customerView.enterMainMenu();
	}
}
