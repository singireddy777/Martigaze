package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByLoginIdAndPassword(String loginId, String password);

}
