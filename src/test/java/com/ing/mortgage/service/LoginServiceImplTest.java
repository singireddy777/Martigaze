package com.ing.mortgage.service;

import java.lang.reflect.InvocationTargetException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.exception.UserNotFoundException;
import com.ing.mortgage.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	CustomerRepository userRepository;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	Customer customer;
	LoginDTO loginDTO;

	@Before
	public void setup() {
		customer = new Customer();
		loginDTO = new LoginDTO();
		customer.setCustomerName("subha");
		loginDTO.setLoginId("subha123");
		loginDTO.setPassword("Hcl@123");
	}

	@Test
	public void testLogin() throws IllegalAccessException, InvocationTargetException, UserNotFoundException {

		Mockito.when(userRepository.findByLoginIdAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customer);
		CustomerDTO customerDTO = loginServiceImpl.login(loginDTO);
		Assert.assertEquals("subha", customerDTO.getCustomerName());

	}

}