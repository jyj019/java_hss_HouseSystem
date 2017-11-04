package com.jyj019.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.User;
import com.jyj019.persistence.UserDao;

/**
 *
 *@Author jyj019
 **/
@Repository
public class UserDaoImpl extends BaseDaoAdapter<User, Integer> implements UserDao {

	@Override
	public User findByUsername(String username) {		
		 List<User> userList=sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:username",User.class)
				.setParameter("username",username)
				.getResultList();
		 return userList.size()==1?userList.get(0):null;
	}
	
	

}
