package com.sravanthi.controller;

import java.util.List;

//import org.hibernate.boot.jaxb.JaxbLogger_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//import ch.qos.logback.classic.Logger;
//import com.sravanthi.ICustomerService;

@RestController
public class CustomerController {
	 private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	private ICustomerService service;
	
	public CustomerController(ICustomerService service) {
		this.service= service;
	}
	
	
	
//test commit
	//added response handling
@PostMapping("/customer/register")
public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) {

    Customer savedCustomer = service.registerCustomer(customer);

    //System.out.println(savedCustomer);
   // final Logger logger=LoggerFactory.getLogger(CustomerController.class);
    logger.info("Customer registered successfully");
   

    return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
}

//loan analysis
@PostMapping("/loan/analyse")
public ResponseEntity<LoanResponse> analyseLoan(
        @RequestBody Customer customer) {
	LoanResponse response=service.analyseLoan(customer);
	//final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	logger.info("Customer registered successfully");
    return ResponseEntity.ok(response);
}

//get customer
@GetMapping("/customer/{id}")
public ResponseEntity<Customer> getCustomerById(
        @PathVariable Long id) {
	Customer customer = service.getCustomerById(id);
	logger.info("Fetched customer {}",id);
    return ResponseEntity.ok(customer);
}


//get all customers
@GetMapping("/customers")
public ResponseEntity<List<Customer>> getAllCustomers() {
	
	List<Customer> customers= service.getAllCustomers();
	logger.info("Fetched all customers");
    return ResponseEntity.ok(customers);
}

//update customer data
@PutMapping("/customer/{id}")
public ResponseEntity<Customer> updateCustomer(
        @PathVariable Long id,
       @Valid @RequestBody Customer customer) {
	Customer UpdatedCustomer=service.updateCustomer(id, customer);
	logger.info("Updated customer {}" ,id);
    return ResponseEntity.ok(UpdatedCustomer);
}

//delete customer based on id
@DeleteMapping("/customer/{id}")
public ResponseEntity<String> deleteCustomer(
        @PathVariable Long id) {

    service.deleteCustomer(id);
logger.info("Deleted customer {}", id);
    return ResponseEntity.noContent().build();
}
}
