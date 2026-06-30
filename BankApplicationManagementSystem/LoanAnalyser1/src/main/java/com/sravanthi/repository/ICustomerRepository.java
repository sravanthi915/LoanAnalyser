package com.sravanthi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravanthi.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	
}
