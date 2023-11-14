package customerData;

import customerManagementSystem.core.*;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


@SuppressWarnings("unused")
public interface CustomerDataBinaryFile {

        static void storeCustomerDetail(List<Customer>lists,String fileName) throws FileNotFoundException, IOException{
        	try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName))){
        		out.writeObject(lists);
        		
        	}
        	
        }
        @SuppressWarnings({ "unchecked" })
        static List<Customer> reStoreCustomerDetail(List<Customer>lists,String fileName) {
        	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName))){
        		
        		return (List<Customer>)in.readObject(); // need to downcast object to list
        		
        	}
        	catch(Exception e) {
        	 e.printStackTrace();
        	}
			return lists;
        	 
        	
        }
	
}
