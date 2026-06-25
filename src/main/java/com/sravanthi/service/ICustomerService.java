package com.sravanthi.service;

import java.util.List;

import com.sravanthi.dto.LoanResponse;
import com.sravanthi.entity.Customer;

public interface ICustomerService {

    Customer registerCustomer(Customer customer);
    LoanResponse analyseLoan(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Long customerId,Customer customer );
    void deleteCustomer(Long customerId);

}
