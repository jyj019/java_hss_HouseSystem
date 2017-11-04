package com.jyj019.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.City;
import com.jyj019.domain.District;
import com.jyj019.persistence.DistrictDao;

@Repository
public class DistrictDaoImpl extends BaseDaoAdapter<District, Integer> implements DistrictDao {


	
	@Override
	public List<District> findAllDistrictsByCity(City city) {
		return sessionFactory.getCurrentSession()
				.createQuery("from District as d where d.city=:city", District.class)
				.setParameter("city", city)
				.getResultList();
	}
}
