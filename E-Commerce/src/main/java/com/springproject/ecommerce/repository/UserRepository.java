package com.springproject.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUnameAndPassword(String un, String psw);
	User findByUname(String un);
	User findByEmail(String email);
	void save(String pwd);

}
