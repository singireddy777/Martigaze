package com.ing.mortgage.exception;

import java.io.Serializable;

public class PropertyCostException extends RuntimeException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final String MESSAGE = "Please provide property cost above 100000€ ";
	
	public PropertyCostException() {
		super(MESSAGE);
	}

}
