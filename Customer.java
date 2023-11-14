package customerManagementSystem.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int idGenerator;
	static {
		idGenerator = 1;
	}
	private int cust_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private LocalDate subsDate;

	public Customer(String first_name, String last_name, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan,LocalDate subsDate) {
		super();
		this.cust_id = idGenerator++;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
		this.subsDate = subsDate;
	}

	public Customer(String email) {
		this.email = email;
	}
	
	public LocalDate getSubsDate() {
		return subsDate;
	}
	

	public ServicePlan getPlan() {
		return plan;
	}

	@Override
	public String toString() {
		return "Customer[cust_id = " + cust_id + " ,Full name = " + first_name + " " + last_name + " , Email = " + email
				+ " ,Password = " + password + " ,Registration Amount = " + registrationAmount + " ,DOB = " + dob
				+ " ,Plan = " + plan +" ,Subscription Date: "+subsDate +" ]";
	}
	@Override
	public int compareTo(Customer anotherCustomer) {
		return email.compareTo(anotherCustomer.email);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer anotherCustomer = (Customer) o;
			return this.email.equals(anotherCustomer.email);
		}
		return false;
	}
	public String getEmail() {
		return email;
	}
	public void setPassword(String pass) {
		this.password = pass;
		System.out.println("Password Successfully changed");
	}

	public String getPassword() {
		return password;
	}
}
