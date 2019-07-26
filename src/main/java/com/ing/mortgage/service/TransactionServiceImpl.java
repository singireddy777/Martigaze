package com.ing.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.TransactionDTO;
import com.ing.mortgage.entity.Transaction;
import com.ing.mortgage.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository ;
	@Override
	public List<TransactionDTO> getTransactions(String accountNumber) {
		List<TransactionDTO> responseTransactionDTO = new ArrayList<>();
		TransactionDTO transactionDTO=new TransactionDTO();
		List<Transaction> transactions= transactionRepository.getByAccount(accountNumber);
		for (Transaction transaction : transactions) {
			transactionDTO.setTransactionId(transaction.getTransactionId());
			transactionDTO.setFromAccount(transaction.getFromAccount());
			transactionDTO.setToAccount(transaction.getToAccount());
			transactionDTO.setAmount(transaction.getAmount());
			transactionDTO.setTransactionDate(transaction.getTransactionDate());
			transactionDTO.setTransactionTime(transaction.getTransactionTime());
			responseTransactionDTO.add(transactionDTO);
			
		}
		return responseTransactionDTO;
	}

}
