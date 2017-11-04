package com.jyj019.persistence.impl;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.HouseType;
import com.jyj019.persistence.HouseTypeDao;
@Repository
public class HouseTypeDaoImpl extends BaseDaoAdapter<HouseType, Integer> implements HouseTypeDao {

}
