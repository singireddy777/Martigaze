package com.ing.mortgage.exception;

import java.io.Serializable;

public class InvalidPhoneNumberException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static final String MESSAGE = "Please provide valid phone number";
	
	public InvalidPhoneNumberException() {
		super(MESSAGE);
	}

}
