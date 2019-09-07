package com.montytest.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montytest.restapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
