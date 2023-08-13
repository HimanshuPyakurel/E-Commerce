package com.springproject.ecommerce.service;

import java.util.List;
import com.springproject.ecommerce.model.User;

public interface IUserService {
	
	User login(String un, String psw);
	void signup(User user);
	User ifExist(String un);
	User getUserByEmail(String email);
	void updatePwd(String pwd);
	User findByUname(String uname);
	List<User> getAllUser();
	void updateUser(User user);
	
}
