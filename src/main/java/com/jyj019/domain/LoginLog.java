package com.jyj019.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 *@Author jyj019
 **/
@Entity
@Table(name="tb_login_log")
public class LoginLog implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loginid",nullable=false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;	
	@Column(name="ipaddr",nullable = false)
	private String ipAddress;
	@Column(nullable = false)
	private Date logDate;
		
	public LoginLog() {
	}
	public LoginLog(User user, String ipaddr, Date date) {
		this.user = user;
		this.ipAddress = ipaddr;
		this.logDate = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipaddr) {
		this.ipAddress = ipaddr;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logdate) {
		this.logDate = logdate;
	}
	
	
}
