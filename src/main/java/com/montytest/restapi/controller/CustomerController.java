package com.montytest.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montytest.restapi.dto.CustomerDto;
import com.montytest.restapi.dto.ListCustomerDto;
import com.montytest.restapi.model.Customer;
import com.montytest.restapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public String addCustomer(@RequestBody CustomerDto customer) {
		customerService.saveCustomer(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), customer.getCountry(), customer.getProvince(), customer.getNotes()));
		return "added";
	}
	
	@PostMapping("/update")
	public String updatedCustomer(@RequestBody CustomerDto customer) {
		customerService.saveCustomer(new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), customer.getCountry(), customer.getProvince(), customer.getNotes()));
		return "updated";
	}
	
	@GetMapping("/all")
	public List<ListCustomerDto> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		List<ListCustomerDto> listCustomerDto = new ArrayList<>();
		for(Customer customer:customers) {
			listCustomerDto.add(new ListCustomerDto(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), customer.getCountry(), customer.getProvince(), customer.getNotes()));
		}
		return listCustomerDto;
	}
}
