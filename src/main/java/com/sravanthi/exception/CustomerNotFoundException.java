package com.sravanthi.exception;

public class CustomerNotFoundException extends RuntimeException {
	//constructor for the user defined exception class
	public CustomerNotFoundException(String message){
		super(message);
	}

}
