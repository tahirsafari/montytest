package com.montytest.restapi.service;

import java.util.List;

import com.montytest.restapi.model.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public Customer getCustomer(Long id);
	public List<Customer> getAllCustomers();
}
