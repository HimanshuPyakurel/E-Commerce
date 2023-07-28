package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecommerce.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
