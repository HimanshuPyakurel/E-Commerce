package com.springproject.ecommerce.utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import com.springproject.ecommerce.model.User;
import com.springproject.ecommerce.repository.UserRepository;
import com.springproject.ecommerce.service.IUserService;

@Component
public class MailUtils {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private IUserService userService;
	
	public void sendEmail(String fromEmail,String toEmail, String subject, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        
        toEmail = "";
        msg.setFrom(fromEmail);
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(message);

        javaMailSender.send(msg);
	}
	
	public void sendEmailBymail(String fromEmail,String toEmail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        
        toEmail = "";
        msg.setFrom(fromEmail);
        msg.setTo(toEmail);
        msg.setSubject("About new arrivals");
        msg.setText("I want to be the first to know about new arrivals");

        javaMailSender.send(msg);
	}
        
        public void forgetpwdEmail(String toEmail) {

    		
    		UUID uuid = UUID.randomUUID();
    		String uuidString = uuid.toString().replace("-","");
    		String pwd = uuidString.substring(0,8);
    		User email = userService.getUserByEmail(toEmail);
    		if (email == null) {
    			System.out.println("Email doesnot exist");
    		}
    		System.out.println(email);
    	    email.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes()));
    	    userRepo.save(email);
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(toEmail);

            msg.setSubject("Reset your password");
            msg.setText("This is your password " + pwd);

            javaMailSender.send(msg);

        }
        
}
