package com.restapi.montytest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.montytest.restapi.MontytestApplication;
import com.montytest.restapi.dto.CustomerDto;


@RunWith(SpringRunner.class)
@ActiveProfiles(value="test")
@SpringBootTest (classes = MontytestApplication.class) 
public class CustomerControllerTests {
	@Autowired
	WebApplicationContext wac;
	@Autowired
	protected ObjectMapper objectMapper;
	protected MockMvc mockMvc;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
        		.webAppContextSetup(wac)
                .build();
	}
	
	@Test
	public void saveCustomer() throws Exception{
		CustomerDto customer = new CustomerDto("David", "Hussey", "david@gmail.com", "192-1234", "US",
				"California", "Sample Customer");
//
		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		String request = objectMapper.writeValueAsString(customer);
		mockMvc.perform(post("/customer/add").contentType(MEDIA_TYPE_JSON_UTF8)
			    .content(request))
			.andExpect(status().isOk())
			//.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());
	}
	
	@Test
	public void getAllCustomers() throws Exception {
		MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", java.nio.charset.Charset.forName("UTF-8"));
		mockMvc.perform(get("/customer/all")
			    .contentType(MEDIA_TYPE_JSON_UTF8))
				.andExpect(status().isOk())
				.andDo(print());
	}
		
}
