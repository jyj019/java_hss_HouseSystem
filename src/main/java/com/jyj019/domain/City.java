package com.jyj019.domain;

import java.io.Serializable;

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
@Table(name="tb_city")
public class City implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cityid",nullable=false)
	private Integer id;
	@Column(name="cityname",nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name="prov_id",nullable=false)
	private Province province;
		
	public City() {
	}
	public City(String name, Province province) {
		this.name = name;
		this.province = province;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
}
