package com.springproject.ecommerce.service;

import com.springproject.ecommerce.model.User;

public interface IUserService {
	
	User login(String un, String psw);
	void signup(User user);
	User ifExist(String un);
	User getUserByEmail(String email);
	void updatePwd(String pwd);
	
}
