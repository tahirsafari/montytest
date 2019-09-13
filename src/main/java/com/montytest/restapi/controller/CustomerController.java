package com.montytest.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.montytest.restapi.config.ApiResponse;
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
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customer) {
		customerService.saveCustomer(new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), customer.getCountry(), customer.getProvince(), customer.getNotes()));
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Customer added successfully"),
                HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatedCustomer(@Valid @RequestBody CustomerDto customer) {
		System.out.println("customer "+customer.toString());
		customerService.updateCustomer(new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber(), customer.getCountry(), customer.getProvince(), customer.getNotes()));
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Customer updated successfully"),
                HttpStatus.OK);
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
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Customer deleted successfully"),
                HttpStatus.OK);
	}
}
