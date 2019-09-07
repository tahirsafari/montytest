package com.montytest.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.montytest.restapi.model","com.montytest.restapi.repository", "com.montytest.restapi.service", "com.montytest.restapi.controller" ,  "com.montytest.restapi.security", "com.montytest.restapi.config.db"})
public class MontytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MontytestApplication.class, args);
	}

}
