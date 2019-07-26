package com.ing.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.TransactionDTO;

@Service
public interface TransactionService {

	List<TransactionDTO> getTransactions(String accountNumber);

}
