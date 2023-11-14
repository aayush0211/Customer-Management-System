package customerManagementSystem.test;

import java.util.ArrayList;
import java.util.Collections;
//import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.utils.CustomSort;
import core.utils.CustomSortDesc;
import customerData.CustomerDataBinaryFile;

import static customerManagementSystem.core.CustomerValidationRules.*;
import customerManagementSystem.core.*;
//import customerManagementSystem.core.ServicePlan;
import static core.utils.CustomerUtils.*;

public class CustomerManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			//List<Customer> customers = new ArrayList<>();
			List<Customer> customers = new ArrayList<>(); //populateCustomer();
			System.out.println("Enter File Name");
			customers = CustomerDataBinaryFile.reStoreCustomerDetail(customers, "CustomerData.ser");
			boolean exit = false;
			while(!exit) {
				System.out.println("Enter Choice: \n1)Sign Up(Regsiter Account)\n2)Sign in(Login to Account) \n3)Change Password \n "
						+ "4)Un-Subscribe Customers\n5)Display all Customers\n6)sorting according email\n "
						+ "7) sorting according Subscription amount\n 8)Remove customers according to plan\n "
						+ "9)Sorting a/c to Desc Plan Amount\n  10)Reverse ORDER A/C TO PLAN using ListIterator \n11)Display customer not paid Subs from last 3 month \n"
						+ "12) Remove Customer not paid subscription from past 6 month \n"
						+ "13) Store Data in a Binary File 0)Exit");
				try {
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter Your Details: \nFirst Name, Last Name,Email,Password ,Registration Amount,Date Of Birth,Subscription plan,Enter date of Subscription");
					System.out.println("Plan Available: SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000)");
						customers.add(allInputCheck(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.next(),customers));
					break;
					
				case 2:do {
						System.out.println("Enter Email and password ");
						
				}while(!find1(sc.next(),sc.next(),customers));
					break;
				case 3:	System.out.println("Enter your Email and current password and New Password");
				       resetPassword(sc.next(),sc.next(),sc.next(), customers);
				        
					break;
				case 4:System.out.println("Enter Email to UN-SUBSCRIBE");
					System.out.println("Removed Customer: "+unSubscribe(sc.next(),customers));
					break;
					
				case 5:for(Customer c : customers) 
					System.out.println(c);
					
					break;
				case 6:
					System.out.println("after sorting as per Email.....: ");
					Collections.sort(customers);
					for(Customer c: customers) 
					System.out.println(c);
					break;
				case 7:
					System.out.println("after sorting as per Price.....: ");
					Collections.sort(customers,new CustomSort());
					for(Customer c: customers) 
					System.out.println(c);
					break;
				case 8:
					System.out.println("enter plan which u want to remove");
					customers = removePlan(customers,sc.next());
					System.out.println("After removing: ");
					for(Customer c : customers)
						System.out.println(c);
					break;
				case 9: System.out.println("Desc a/c to Plan ");
				Collections.sort(customers,new CustomSortDesc());
				for(Customer c: customers) 
				System.out.println(c);
				break;
				case 10: System.out.println("Desc using ListIterator a/c to plan");
				//Collections.sort(customers,new CustomSort()); 
					reverseIterator(customers);
					break;
				case 11:
					System.out.println("Customer not paid Subs from last 3 month");
					last3Month(customers);
					break;
				case 12:
					System.out.println("Remove Customer not paid Subs from last 6 month");
					customers=subsPaid(customers);
					for(Customer c: customers)
						System.out.println(c);
					break;
				case 13:
					CustomerDataBinaryFile.storeCustomerDetail(customers, "CustomerData.ser");
					System.out.println("Succesfully Stored");
				case 0:
					System.out.println("Thank You! ");
					sc.close();
					exit=true;
					break;
				}
				}
				catch(Exception e) {
					System.out.println("Catch-all");
					System.out.print(e);
					e.printStackTrace();
					sc.nextLine();
				}
			}
			
		}
	}

}
