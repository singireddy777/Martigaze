package com.ing.mortgage.exception;

import java.io.Serializable;

public class RestrictedAgeException extends RuntimeException implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final String MESSAGE = "Sorry we are unable to grant you the mortgage at this moment";
	
	public RestrictedAgeException() {
		super(MESSAGE);
	}

}
