package com.cms.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.cms.core.Customer;

public interface IOUtils {
	// add a static methods to store customer details 
	// from the map in binary file using serialization
	static void storeCustomerDetails(Map<String, Customer> customers, String fileName)
			throws IOException{

		// Java Application --> OOS:serialization(object->binary) --> FOS:abstraction or 
		// node stream for writing the data to binary file -->  binary file
		try(ObjectOutputStream out = new ObjectOutputStream
				(new FileOutputStream(fileName))){
			
			out.writeObject(customers);
			
		}
	}
	
	// add a static methods to store customer details 
	// from the serialized binary file(.ser) in map using deserialization
	@SuppressWarnings("unchecked")
	static Map<String, Customer> restoreCustomerDetails(String fileName) {
		
		// Java Application <-- OIS: deserialization(binary -> object) <-- FIS(binary file)
		try(ObjectInputStream in = new ObjectInputStream
				(new FileInputStream(fileName))){
			return (HashMap<String, Customer>)in.readObject();
			
		}catch (Exception e) {
			System.out.println(e);
			return new HashMap<>();
		}
	}
	
	
	
}










