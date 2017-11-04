package com.jyj019.service.impl;

import java.util.Date;

import com.jyj019.dto.UserRegisterDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyj019.domain.LoginLog;
import com.jyj019.domain.User;
import com.jyj019.dto.UserLoginDto;
import com.jyj019.persistence.LoginLogDao;
import com.jyj019.persistence.UserDao;
import com.jyj019.service.UserService;

@Service
@Transactional//事务环境
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	@Override
	public boolean login(UserLoginDto user) {
		System.out.println(user.getIpAddress());
		boolean flag = false;
		User temp = userDao.findByUsername(user.getUsername());
		if (temp != null) {
			String md5 = DigestUtils.md5Hex(user.getPassword());
			flag = temp.getPassword().equals(md5);
			if (flag) {
				user.setId(temp.getId());
				user.setRealname(temp.getRealname());
				LoginLog loginLog = new LoginLog();
				loginLog.setUser(temp);
				loginLog.setIpAddress(user.getIpAddress());
				loginLog.setLogDate(new Date());
				loginLogDao.save(loginLog);
			}
		}
		return flag;
	}

	@Override
	public boolean register(UserRegisterDto user) {
		User temp = userDao.findByUsername(user.getUsername());
		if (temp == null) {
			String md5 = DigestUtils.md5Hex(user.getPassword());
			User user1=new User(user.getUsername(), md5,user.getRealname(),user.getTel(),false);
			return userDao.save(user1)!= null;
		}
		return false;
	}

	@Override
	public boolean checkUnique(String username) {
		return userDao.findByUsername(username)==null;
	}

}
