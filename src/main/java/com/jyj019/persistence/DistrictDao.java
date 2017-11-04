package com.jyj019.persistence;

import java.util.List;

import com.jyj019.domain.City;
import com.jyj019.domain.District;
/**
 *
 *@Author jyj019
 **/
public interface DistrictDao extends BaseDao<District, Integer>{
	List<District> findAllDistrictsByCity(City city);
}
