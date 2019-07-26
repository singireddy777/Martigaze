package com.ing.mortgage.service;

import java.util.List;

import com.ing.mortgage.dto.AccountDTO;
import com.ing.mortgage.dto.MortgageRequsetDTO;
import com.ing.mortgage.dto.MortgageResponseDTO;

public interface MortgageService {

	public MortgageResponseDTO createMortgage(MortgageRequsetDTO mortgageRequsetDTO);

	public List<AccountDTO> fetchAccountByCustomerId(Long customerId);

	public String fundTransfer(String fromAccount, String toAccount, Double amount);

	

}
