package com.ing.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.RequestTransactionDTO;
import com.ing.mortgage.dto.TransactionDTO;
import com.ing.mortgage.entity.Transaction;
import com.ing.mortgage.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {

	@Mock
	TransactionRepository transactionRepository;

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;

	RequestTransactionDTO RequestTransactionDTO;
	List<Transaction> transaction;
	List<TransactionDTO> listTransactionDTO;
	TransactionDTO transactionDTO;

	@Before
	public void setup() {
		listTransactionDTO = new ArrayList<>();
		transactionDTO = new TransactionDTO();
		RequestTransactionDTO = new RequestTransactionDTO();
		transaction = new ArrayList<>();
		RequestTransactionDTO.setAccountNumber("ACC25");
	}

	@Test
	public void testTransactions() {
		Mockito.when(transactionRepository.getByAccount(Mockito.anyString())).thenReturn(transaction);
		listTransactionDTO = transactionServiceImpl.getTransactions(Mockito.anyString());
		Assert.assertEquals("ACC25", RequestTransactionDTO.getAccountNumber());
	}
}
