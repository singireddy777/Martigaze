package com.ing.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.AccountDTO;
import com.ing.mortgage.entity.Account;
import com.ing.mortgage.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class MortgageServiceImplTest {

	@InjectMocks
	private MortgageServiceImpl mortgageServiceImpl;

	@Mock
	private AccountRepository accountRepository;

	@Test
	public void fetchAccountByCustomerId() {

		List<Account> accountList = new ArrayList<>();
		Account account1 = new Account();
		account1.setAccountId(1L);
		accountList.add(account1);
		Account account2 = new Account();
		account2.setAccountId(1L);
		accountList.add(account2);
		Mockito.when(accountRepository.findByCustomerId(Mockito.anyLong())).thenReturn(accountList);
		List<AccountDTO> accounts = mortgageServiceImpl.fetchAccountByCustomerId(1L);
		Assert.assertEquals(2, accounts.size());

	}

}
