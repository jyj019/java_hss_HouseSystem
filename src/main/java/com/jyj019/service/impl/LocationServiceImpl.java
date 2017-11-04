package com.jyj019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyj019.domain.City;
import com.jyj019.domain.District;
import com.jyj019.domain.Province;
import com.jyj019.persistence.CityDao;
import com.jyj019.persistence.DistrictDao;
import com.jyj019.persistence.ProvinceDao;
import com.jyj019.service.LocationService;

@Service
@Transactional(readOnly=true)
public class LocationServiceImpl implements LocationService {
	@Autowired
	private ProvinceDao provinceDao;	
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;
	
	@Override
	public List<Province> listAllProvinces() {
		return provinceDao.findAll();
	}

	@Override
	public List<City> listAllCitiesByProvince(Province province) {
		return cityDao.findAllCitiesByProvince(province);
	}

	@Override
	public List<District> listAllDistrictsByCity(City city) {
		return districtDao.findAllDistrictsByCity(city);
	}

}
