package com.ing.mortgage.exception;

public class CustomerAccountNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE="Customer Account not available for this Id";
	
	public CustomerAccountNotFound(Long customerId) {
		super(MESSAGE + customerId);
	}

}
