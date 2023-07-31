package com.springproject.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class Cart {
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  private int id;
	  private int quantity;
	  
	  @ManyToOne
	  private Product product;

	  public Cart(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	  }	   
	   
	  public Cart() {
		super();
	  }
	  
}
