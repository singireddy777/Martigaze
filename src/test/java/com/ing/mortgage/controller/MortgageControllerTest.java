package com.ing.mortgage.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.mortgage.dto.AccountDTO;
import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.MortgageRequsetDTO;
import com.ing.mortgage.dto.MortgageResponseDTO;
import com.ing.mortgage.service.MortgageService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MortgageController.class)
public class MortgageControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	MortgageService mortgageService;
	CustomerDTO customerDTO;
	List<AccountDTO> listAccountDTO = new ArrayList<>();
	AccountDTO account = new AccountDTO();

	MortgageResponseDTO mortgageResponseDTO;

	MortgageRequsetDTO mortgageRequsetDTO;

	@Before
	public void setup() {
		customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(1L);
		listAccountDTO = new ArrayList<AccountDTO>();
		account = new AccountDTO();
		account.setAccountNumber("Acc001");
		listAccountDTO.add(account);
		mortgageResponseDTO = new MortgageResponseDTO();

		mortgageRequsetDTO = new MortgageRequsetDTO();

	}

	@Test
	public void getAccountSummaryTest() throws Exception {

		Mockito.when(mortgageService.fetchAccountByCustomerId(customerDTO.getCustomerId())).thenReturn(listAccountDTO);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/1").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(listAccountDTO))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test

	public void mortgageTest() throws Exception {

		Mockito.when(mortgageService.createMortgage(mortgageRequsetDTO)).thenReturn(mortgageResponseDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/mortgage").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(mortgageResponseDTO))).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
