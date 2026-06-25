package com.sravanthi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sravanthi.entity.Customer;
import com.sravanthi.service.ICustomerService;
//import com.sravanthi.ICustomerService;

@RestController
public class CustomerController {
	private ICustomerService service;
	
	public CustomerController(ICustomerService service) {
		this.service= service;
	}
	
	@PostMapping("/customer/register")
	public void registerCustomer(@RequestBody Customer customer) {
		service.registerCustomer(customer);
;		
}
}
