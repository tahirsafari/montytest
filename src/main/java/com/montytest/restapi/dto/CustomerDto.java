package com.montytest.restapi.dto;

import javax.validation.constraints.NotBlank;

public class CustomerDto {
	private Long id;
	@NotBlank(message = "First Name can not be left blank")
	private String firstName;
	@NotBlank(message = "Last Name can not be left blank")
	private String lastName;
	@NotBlank(message = "Email can not be left blank")
	private String email;
	@NotBlank(message = "Mobile Number can not be left blank")
	private String mobileNumber;
	@NotBlank(message = "Country can not be left blank")
	private String country;
	@NotBlank(message = "Province can not be left blank")
	private String province;
	private String notes;
	
	public CustomerDto() {}
	public CustomerDto(String firstName, String lastName, String email, String mobileNumber, String country,
			String province, String notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.country = country;
		this.province = province;
		this.notes = notes;
	}
	public CustomerDto(Long id, String firstName, String lastName, String email, String mobileNumber, String country,
			String province, String notes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.country = country;
		this.province = province;
		this.notes = notes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", country=" + country + ", province=" + province + ", notes="
				+ notes + "]";
	}
	
	
}
