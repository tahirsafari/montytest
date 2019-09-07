package com.montytest.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.montytest.restapi.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
