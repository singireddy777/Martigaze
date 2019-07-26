package com.ing.mortgage.controller;


import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.LoginDTO;
import com.ing.mortgage.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
@RequestMapping("api")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@PutMapping("/login")
	public ResponseEntity<CustomerDTO> login(@RequestBody LoginDTO loginDTO) throws IllegalAccessException, InvocationTargetException{
		CustomerDTO customerDTO = loginService.login(loginDTO);
		LOGGER.info("success");
		return new ResponseEntity<>(customerDTO ,HttpStatus.OK);
	}
}
