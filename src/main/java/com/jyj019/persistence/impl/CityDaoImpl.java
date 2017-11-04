package com.jyj019.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.City;
import com.jyj019.domain.Province;
import com.jyj019.persistence.CityDao;

@Repository
public class CityDaoImpl extends BaseDaoAdapter<City, Integer> implements CityDao {

	@Override
	public List<City> findAllCitiesByProvince(Province province) {
		return sessionFactory.getCurrentSession()
				.createQuery("from City as c where c.province=:province",City.class)
				.setParameter("province",province ).getResultList();
	}

}
