package core.utils;

import java.util.Comparator;

import customerManagementSystem.core.Customer;

public class CustomSort implements Comparator<Customer> {
		@Override
		public int compare(Customer c1, Customer c2) {
			if(c1.getPlan().getAdditionalCost() < c2.getPlan().getAdditionalCost()) {
				return -1;
			}
			if(c1.getPlan().getAdditionalCost() > c2.getPlan().getAdditionalCost()) {
				return 1;
			}
			return 0;
		}
		
}
