package com.jyj019.dto;

import com.jyj019.domain.HouseType;
/**
 *
 *@Author jyj019
 **/
public class searchHouseParam {
	private String title;
	private String price;
	private HouseType houseType;
	private String area;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getMinPrice() {
		return this.price.equals("不限")?
			0.0:Double.parseDouble(this.price.split("-")[0]);
	}
	public Double getMaxPrice() {
		return this.price.equals("不限")?
				Double.MAX_VALUE:Double.parseDouble(this.price.split("-")[0]);
	}	
	
	public void setPrice(String price) {
		this.price = price;
	}
	public HouseType getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	public Integer getMinArea() {
		return this.price.equals("不限")?
			0:Integer.parseInt(this.price.split("-")[0]);
	}
	public Integer getMaxArea() {
		return this.price.equals("不限")?
			Integer.MAX_VALUE:Integer.parseInt(this.price.split("-")[0]);
	}	
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
