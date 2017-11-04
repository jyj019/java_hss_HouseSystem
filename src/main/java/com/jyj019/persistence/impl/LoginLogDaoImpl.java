package com.jyj019.persistence.impl;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.LoginLog;
import com.jyj019.persistence.LoginLogDao;

@Repository
public class LoginLogDaoImpl extends BaseDaoAdapter<LoginLog, Integer> implements LoginLogDao {

}
