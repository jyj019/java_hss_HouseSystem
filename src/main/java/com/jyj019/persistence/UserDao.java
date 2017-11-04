package com.jyj019.persistence;

import com.jyj019.domain.User;
/**
 *
 *@Author jyj019
 **/
public interface UserDao extends BaseDao<User, Integer>	{
	
	User findByUsername(String name);
}
