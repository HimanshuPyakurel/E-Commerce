package com.springproject.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.repository.UserRepository;
import com.springproject.ecommerce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User login(String un, String psw) {		
		return userRepo.findByUnameAndPassword(un, psw);
	}

	@Override
	public void signup(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User ifExist(String un) {
		return userRepo.findByUname(un);
	}
	
	@Override
	public User getUserByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}


	@Override
	public void updatePwd(String pwd) {
		userRepo.save(pwd);
		
	}


	
}
