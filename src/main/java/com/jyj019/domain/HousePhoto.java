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
@Table(name="tb_house_photo")
public class HousePhoto implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="photoid",nullable=false)
	private Integer id;
	@Column(name="photoname",nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(name="house_id",nullable = false)
	private House house;
	
	
	public HousePhoto() {
	}
	public HousePhoto( String name, House house) {
		this.name = name;
		this.house = house;
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
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	
}
