package com.ing.mortgage.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MortgageResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String loginId;
	private String password;
	private String mortgageNumber;
	private String customerName;
	private String accountNumber;
}
