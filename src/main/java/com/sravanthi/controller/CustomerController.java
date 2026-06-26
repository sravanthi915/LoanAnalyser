package com.sravanthi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.sravanthi.dto.LoanResponse;
import com.sravanthi.entity.Customer;
import com.sravanthi.service.ICustomerService;
//import com.sravanthi.ICustomerService;

@RestController
public class CustomerController {
	private ICustomerService service;
	
	public CustomerController(ICustomerService service) {
		this.service= service;
	}
//test commit
	//added response handling
@PostMapping("/customer/register")
public Customer registerCustomer(@Valid @RequestBody Customer customer) {

    Customer savedCustomer = service.registerCustomer(customer);

    System.out.println(savedCustomer);

    return savedCustomer;
}
@PostMapping("/loan/analyse")
public LoanResponse analyseLoan(
        @RequestBody Customer customer) {
	
    return service.analyseLoan(customer);
}
@GetMapping("/customer/{id}")
public Customer getCustomerById(
        @PathVariable Long id) {

    return service.getCustomerById(id);
}
@GetMapping("/customers")
public List<Customer> getAllCustomers() {
    return service.getAllCustomers();
}
@PutMapping("/customer/{id}")
public Customer updateCustomer(
        @PathVariable Long id,
        @RequestBody Customer customer) {

    return service.updateCustomer(id, customer);
}
@DeleteMapping("/customer/{id}")
public String deleteCustomer(
        @PathVariable Long id) {

    service.deleteCustomer(id);

    return "Customer Deleted Successfully";
}
}
