package com.sravanthi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravanthi.dto.LoanResponse;
import com.sravanthi.entity.Customer;
import com.sravanthi.exception.CustomerNotFoundException;
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

	@Override
	public LoanResponse analyseLoan(Customer customer) {

	    double netIncome =
	            customer.getSalary()
	          - customer.getMonthlyExpense()
	          - customer.getExistingEmi();

	    LoanResponse response = new LoanResponse();

	    response.setCustomerName(customer.getName());

	    if(netIncome > 30000) {
	        response.setEligibleLoanAmount(netIncome * 60);
	        response.setStatus("Eligible");
	    }
	    else if(netIncome > 15000) {
	        response.setEligibleLoanAmount(netIncome * 30);
	        response.setStatus("Partially Eligible");
	    }
	    else {
	        response.setEligibleLoanAmount(0.0);
	        response.setStatus("Not Eligible");
	    }

	    return response;
	}

	@Override
	public Customer getCustomerById(Long id) {

		return repo.findById(id)
		        .orElseThrow(() ->
		            new CustomerNotFoundException(
		                "Customer with ID " + id + " not found"));
	}
		
//	Customer customer = repo.findById(id)
//	        .orElseThrow(() -> new CustomerNotFoundException(
//	                "Customer with ID " + id + " not found"));

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		// TODO Auto-generated method stub

		    Customer existingCustomer = repo.findById(customerId)
		            .orElseThrow(() ->
		            new CustomerNotFoundException("Customer with" +customerId +"Not found"));

		    existingCustomer.setName(customer.getName());
		    existingCustomer.setEmail(customer.getEmail());
		    existingCustomer.setSalary(customer.getSalary());
		    existingCustomer.setMonthlyExpense(customer.getMonthlyExpense());
		    existingCustomer.setExistingEmi(customer.getExistingEmi());

		    return repo.save(existingCustomer);
		}

	@Override
		public void deleteCustomer(Long id) {

		Customer customer = repo.findById(id)
		        .orElseThrow(() ->
		            new CustomerNotFoundException(
		                "Customer with ID " + id + " not found"));
		}
		
	}
	
	
	


