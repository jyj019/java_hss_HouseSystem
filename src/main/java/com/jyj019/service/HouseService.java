package com.jyj019.service;

import java.util.List;

import com.jyj019.domain.House;
import com.jyj019.domain.HouseType;
import com.jyj019.dto.PageBean;
import com.jyj019.dto.searchHouseParam;
/**
 *
 *@Author jyj019
 **/
public interface HouseService {
	/**
	 * 列出所有房屋类型
	 * @return 保存部门房屋类型的列表容器
	 */
	List<HouseType> listAllHouseTypes();
	
	boolean publishNewHouse(House house);
	
	PageBean<House> listHousesByPage(int page,int size);
	
	PageBean<House> searchHouseWithParamByPage(searchHouseParam param,int page,int size);
}
