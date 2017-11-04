package com.jyj019.persistence;

import java.util.List;

import com.jyj019.domain.City;
import com.jyj019.domain.Province;
/**
 *
 *@Author jyj019
 **/
public interface CityDao extends BaseDao<City, Integer>{
	List<City> findAllCitiesByProvince(Province province);
}
