package com.projectems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.dao.UserRepository;
import com.projectems.entities.User;
import com.projectems.service.UserService; 

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String username, String userPassword) {
		User user=userRepository.findByUserNameAndPassword(username, userPassword);
		return user;
	}

}

