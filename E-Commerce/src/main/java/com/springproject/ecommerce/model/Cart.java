package com.springproject.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart")
public class Cart {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id")
	  private int id;

	  @OneToOne
	  private Product product;

	  @Column(name = "grand_total")
	  private double grandTotal;

	  @Column(name = "cart_lines")
	  private int cartLines;
	  
	  @OneToOne
	  private User user;
}
