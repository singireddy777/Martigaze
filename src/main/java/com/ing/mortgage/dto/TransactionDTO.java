package com.ing.mortgage.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private LocalDate transactionDate;
	private LocalTime transactionTime;
}
