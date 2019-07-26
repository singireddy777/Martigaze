package com.ing.mortgage.service;

import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Service;

import com.ing.mortgage.dto.CustomerDTO;
import com.ing.mortgage.dto.LoginDTO;

@Service
public interface LoginService {

	CustomerDTO login(LoginDTO loginDTO) throws IllegalAccessException, InvocationTargetException  ;

}
