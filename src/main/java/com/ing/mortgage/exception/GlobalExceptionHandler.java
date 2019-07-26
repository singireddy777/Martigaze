package com.ing.mortgage.exception;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = {RestrictedAgeException.class})
	public ResponseEntity<ResponseError> ageException(Exception e){
		ResponseError error = new ResponseError(e.getMessage(),org.springframework.http.HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,org.springframework.http.HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = { FundTransferException.class })
	public ResponseEntity<ResponseError> fundError(Exception e) {
	ResponseError accountError = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<>(accountError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {PropertyCostException.class})
	public ResponseEntity<ResponseError> propertyException(Exception e){
		ResponseError error = new ResponseError(e.getMessage(),org.springframework.http.HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,org.springframework.http.HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = {InvalidPhoneNumberException.class})
	public ResponseEntity<ResponseError> phoneException(Exception e){
		ResponseError error = new ResponseError(e.getMessage(),org.springframework.http.HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,org.springframework.http.HttpStatus.BAD_REQUEST);
		
	}


	@ExceptionHandler(value = { UserNotFoundException.class })
	public ResponseEntity<ResponseError> loginError(Exception e) {
		ResponseError loginError = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(loginError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { CustomerAccountNotFound.class })
	public ResponseEntity<ResponseError> accountError(Exception e) {
		ResponseError accountError = new ResponseError(e.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(accountError, HttpStatus.NOT_FOUND);
	}


}
