package com.ing.mortgage.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Mortgage implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mortgageId;	
	private String operationType;	
	private Double propertyCost;	
	private Double deposit;	
	private String employmentStatus;	
	private String occupation;	
	private String contractType;	
	private LocalDate dateOfJoining;	
	private String title;	
	private String firstName;	
	private String middleName;	
	private String surName;	
	private LocalDate dateOfBirth;	
	private Long phoneNumber;
	private String email;	
	private String confirmEmail;
	@OneToOne
	@JoinColumn(name="customerId")
	private Customer customer;

}
