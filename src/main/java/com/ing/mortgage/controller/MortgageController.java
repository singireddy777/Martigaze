package com.ing.mortgage.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.AccountDTO;
import com.ing.mortgage.dto.FundDTO;
import com.ing.mortgage.dto.MortgageRequsetDTO;
import com.ing.mortgage.dto.MortgageResponseDTO;
import com.ing.mortgage.service.MortgageService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class MortgageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageController.class);
	
	@Autowired
	MortgageService mortgageService;

	@PostMapping("/mortgage")
	public ResponseEntity<MortgageResponseDTO> mortgage(@RequestBody MortgageRequsetDTO mortgageRequsetDTO) {
		LOGGER.info("Inside mortgage");
		MortgageResponseDTO mortgageResponseDTO = mortgageService.createMortgage(mortgageRequsetDTO);
		return new ResponseEntity<>(mortgageResponseDTO, HttpStatus.CREATED);

	}
	
	

	@GetMapping("/accounts/{customerId}")
	public ResponseEntity<List<AccountDTO>> getAccountSummary(@PathVariable Long customerId) {
		LOGGER.info("Inside getAccountSummary");
		List<AccountDTO> listDTO = mortgageService.fetchAccountByCustomerId(customerId);
		return new ResponseEntity<>(listDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> fundTransfer(@RequestBody FundDTO transactionDTO){
	String result = mortgageService.fundTransfer(transactionDTO.getFromAccount(), transactionDTO.getToAccount(), transactionDTO.getAmount());
	return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
	}
	
}
