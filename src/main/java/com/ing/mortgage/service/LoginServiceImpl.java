package com.ing.mortgage.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.exception.UserNotFoundException;
import com.ing.mortgage.repository.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerDTO login(LoginDTO loginDTO) throws IllegalAccessException, InvocationTargetException {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = customerRepository.findByLoginIdAndPassword(loginDTO.getLoginId(), loginDTO.getPassword());
		if (customer != null) {
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setMessage("login successfull");
			return customerDTO;
		} else {
			throw new UserNotFoundException();
		}
	}

}
