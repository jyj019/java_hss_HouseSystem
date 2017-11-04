package com.jyj019.service;

import com.jyj019.domain.User;
import com.jyj019.dto.UserLoginDto;
import com.jyj019.dto.UserRegisterDto;

/**
 *
 *@Author jyj019
 **/
public interface UserService {

	boolean login(UserLoginDto user);
	
	boolean register(UserRegisterDto user);
	
	boolean checkUnique(String username);
}
