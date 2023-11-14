package core.utils;

import java.util.Comparator;

import customerManagementSystem.core.Customer;

public class CustomSortDesc implements Comparator<Customer> {
	@Override
	public int compare(Customer c1, Customer c2) {
//		if(c1.getPlan().getAdditionalCost() < c2.getPlan().getAdditionalCost()) {
//			return 1;
//		}
//		if(c1.getPlan().getAdditionalCost() > c2.getPlan().getAdditionalCost()) {
//			return -1;
//		}
//	
	Integer i = c1.getPlan().getAdditionalCost();
	Integer i2= c2.getPlan().getAdditionalCost();
	if(i.equals(i2))
		return c1.getEmail().compareTo(c2.getEmail());
	return i2.compareTo(i);
	}
}
