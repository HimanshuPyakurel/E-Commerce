package com.springproject.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "address_line_1", nullable = false, length = 512)
	private String addressLine1;

    @Column(name = "address_line_2", length = 512)
	private String addressLine2;

	@Column(name = "city", nullable = false)
	private String city;
	  
	@Column(name = "state", nullable = false, length = 75)
	private String state;
	
	@Column(name = "country", nullable = false, length = 75)
	private String country;
	
	@Column(name = "shipping")
    private boolean shipping;

    @Column(name = "billing")
    private boolean billing;
	  
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
