package com.sravanthi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravanthi.entity.Customer;
import com.sravanthi.repository.ICustomerRepository;
@Service
public class CustomerService implements ICustomerService {
	@Autowired
	private ICustomerRepository repo;
	
	public CustomerService(ICustomerRepository repo) {
		this.repo=repo;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}
	
	}
	


