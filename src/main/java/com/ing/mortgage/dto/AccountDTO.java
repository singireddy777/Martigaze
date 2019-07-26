package com.ing.mortgage.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long accountId;
	private String accountNumber;
	private String accountType;
	private Double balance;
	private LocalDate date;
}
