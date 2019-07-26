package com.ing.mortgage.exception;


import java.io.Serializable;

public class FundTransferException extends RuntimeException implements Serializable{

/**
* 
*/
private static final long serialVersionUID = 1L;

private static final String MESSAGE="Invalid source account : ";
public FundTransferException(String account) {
super(MESSAGE + account);
}

}
