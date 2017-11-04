package com.jyj019.service;

import java.util.List;

import com.jyj019.domain.City;
import com.jyj019.domain.District;
import com.jyj019.domain.Province;
/**
 *
 *@Author jyj019
 **/
public interface LocationService {
	/**
	 * 列出所有省
	 * @return 保存省对象的列表容器
	 */
	List<Province> listAllProvinces();
	
	/**
	 * 列出所有市
	 * @return 保存市对象的列表容器
	 */
	List<City> listAllCitiesByProvince(Province province);
	
	/**
	 * 列出所有地区
	 * @return 保存地区对象的列表容器
	 */
	List<District> listAllDistrictsByCity(City city);

}
