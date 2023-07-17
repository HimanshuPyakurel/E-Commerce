package com.springproject.ecommerce.model;

import lombok.Data;

@Data
public class UserModel {

    private int id;
    private String fullName;
    private String email;
    private Cart cart;
}
