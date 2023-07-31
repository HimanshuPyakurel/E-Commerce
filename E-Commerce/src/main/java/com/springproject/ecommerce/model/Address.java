package com.springproject.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String fname;
	private String lname;
	private String country;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String notes;
	private String email;
	
}
