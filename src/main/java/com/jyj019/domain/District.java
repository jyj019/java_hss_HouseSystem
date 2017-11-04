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
@Table(name="tb_district")
public class District implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="distid",nullable=false)
	private Integer id;
	@Column(name="distname",nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name="city_id",nullable=false)
	private City city;
	
		
	public District() {
	}
	public District(String name, City city) {
		this.name = name;
		this.city = city;
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
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
		
}
