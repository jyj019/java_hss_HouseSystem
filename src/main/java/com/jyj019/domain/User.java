package com.jyj019.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 *@Author jyj019
 **/
@Entity
@Table(name="tb_user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid",nullable=false)
	private Integer id;
	@Column(length = 20,nullable = false)
	//@Pattern(regexp ="\\w{2,20}")
	private String username;
	@Column(nullable = false)
	//@Size(min=2,max=20)
	private String password;
	private String realname;
	private String tel;
	@Column(name="isadmin")
	private Boolean admin;
//	@Transient
//	private String ipAddress;
//	private Transaction String ipAdress;

	public User() {
	}

	public User(Integer id) {
		this.id =id;
	}
	
	public User(String username, String password, String realname, String tel, Boolean admin) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.tel = tel;
		this.admin = admin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
