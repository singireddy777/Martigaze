package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Mortgage;

@Repository
public interface MortgageRepository extends JpaRepository<Mortgage, Long> {

}
