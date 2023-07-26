package com.springproject.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class Cart {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;

	  @Column(name = "quantity")
	  private int quantity;
	  
	  @Column(name = "total_price")
	  private double totalPrice;
	  
	  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinColumn(name = "shoppingcartId")
	  private ShoppingCart cart;

	   @OneToOne(fetch = FetchType.EAGER)
	   @JoinColumn(name = "productId")
	   private Product product;
	  
	  
}
