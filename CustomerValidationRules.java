package customerManagementSystem.core;

import static java.time.LocalDate.*;

import java.time.LocalDate;
import java.util.List;

import customerManagementSystem.exceptionHandling.CustomerExceptionHandling;

public class CustomerValidationRules {

	public static void checkDups(String email, List<Customer> customers) throws CustomerExceptionHandling {
		Customer newCustomer = new Customer(email);
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		if(newCustomer.getEmail().matches(regex)) {
		if (customers.contains(newCustomer) ) {
			throw new CustomerExceptionHandling("Duplicate Customer email id not allowed");
			}
			//else {
//			System.out.println("Successfully registered");
//		}
	}else {
		throw new CustomerExceptionHandling("Wrong Email Format");
	}
		}
	public static void strongPassword(String password) throws CustomerExceptionHandling {
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		 if (password == null) {
	            System.out.println("No Password input");
	        }
		if(password.matches(regex)) {
			System.out.println("Successfully registered");
		}else {
			throw new CustomerExceptionHandling("Use Strong Password contains: 1)Atleast one lower case\n 2)Aleast one upper case\n3)Atleast one special Character\n4)Atleast one numerical\n5)Atleast contains 8 letters and atmost 20 letters");
		}
	}

	public static ServicePlan checkPlan(String plan) throws IllegalArgumentException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}

	public static Customer allInputCheck(String first_name, String last_name, String email, String password,
			double registrationAmount, String dob, String plan,String subsDate, List<Customer> customers)
			throws CustomerExceptionHandling, IllegalArgumentException {
		checkDups(email, customers);
		strongPassword(password);
		ServicePlan validPlan = checkPlan(plan);
		if (validPlan.getAdditionalCost() != registrationAmount)
			throw new CustomerExceptionHandling("Amount not match to valid plan");
		LocalDate validDOB = parse(dob);
		LocalDate vsubsDate = parse(subsDate);
		return new Customer(first_name, last_name, email, password, registrationAmount, validDOB, validPlan, vsubsDate);
	}

	public static boolean find1(String email, String password, List<Customer> customers)
			throws CustomerExceptionHandling {
		Customer newCustomer = new Customer(email);
		if (customers.contains(newCustomer)) {
			//System.out.println("Email Exists");
			int i = customers.indexOf(newCustomer);
			//for (Customer c : customers) {
				//if (c.getPassword().equals( password)) {
			if(customers.get(i).getPassword().equals(password)) {
					System.out.println("Sign In Successfull");

					return true;
				}
			else {
			System.out.println("Wrong Password . Enter again ");
			return false;
			}
		}

		throw new CustomerExceptionHandling("Account not Found. Check again");

	}

	public static void resetPassword(String email, String password, String newPassword, List<Customer> customers)
			throws CustomerExceptionHandling {
		Customer newCustomer = new Customer(email);
		int i = customers.indexOf(newCustomer);
		if (i == -1) {
			throw new CustomerExceptionHandling("Account not Found. Check again");
		}
		if (customers.get(i).getPassword().equals(password)) {

			customers.get(i).setPassword(newPassword);
		}else {
		System.out.println("Wrong Password . Enter again ");
	
		}
		}

	public static Customer unSubscribe(String email, List<Customer> customers) throws CustomerExceptionHandling {
		Customer newCustomer = new Customer(email);
		int i = customers.indexOf(newCustomer);
		if (i == -1) {
			throw new CustomerExceptionHandling("Account not Found. Check again");
		}
		return customers.remove(i);
	}
}
