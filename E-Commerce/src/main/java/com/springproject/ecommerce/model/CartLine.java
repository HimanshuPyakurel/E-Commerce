package com.springproject.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_line")
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    private Product product;

    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "total")
    private double total;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "buying_price")
    private double buyingPrice;

    @Column(name = "is_available")
    private boolean isAvailable;

}
