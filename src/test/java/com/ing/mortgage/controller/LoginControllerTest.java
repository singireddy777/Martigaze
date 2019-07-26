package com.ing.mortgage.controller;

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
import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.service.LoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LoginService loginService;
	
	LoginDTO loginDTO;
	CustomerDTO customerDTO;

	@Test
	public void testLogin() throws Exception {
			loginDTO = new LoginDTO();
		 customerDTO = new CustomerDTO();
		 
		 loginDTO.setLoginId("sample");
		 loginDTO.setPassword("sample");
		Mockito.when(loginService.login(loginDTO)).thenReturn(customerDTO);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/login")
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(customerDTO)))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
