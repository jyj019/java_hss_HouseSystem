package com.jyj019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyj019.domain.House;
import com.jyj019.domain.HouseType;
import com.jyj019.dto.PageBean;
import com.jyj019.dto.searchHouseParam;
import com.jyj019.persistence.HouseDao;
import com.jyj019.persistence.HouseTypeDao;
import com.jyj019.service.HouseService;
import com.jyj019.util.HQLQueryBean;
import com.jyj019.util.QueryBean;

@Service
//@Transactional//事务环境  粗粒度事务
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseTypeDao houseTypeDao;
	@Autowired
	private HouseDao houseDao;
	
	@Transactional(readOnly=true) //细粒度事务
	@Override
	public List<HouseType> listAllHouseTypes() {
		return houseTypeDao.findAll();
	}
	
	@Transactional
	@Override
	public boolean publishNewHouse(House house) {
		return houseDao.save(house) != null;
	}
	
	@Transactional(readOnly=true)
	@Override
	public PageBean<House> listHousesByPage(int page, int size) {
		return houseDao.findByPage(page,size);
	}
	
	@Transactional(readOnly = true)
	@Override
	public PageBean<House> searchHouseWithParamByPage(searchHouseParam param, int page, int size) {
		QueryBean queryBean = new HQLQueryBean(House.class)
				.addCondition("title like ?", "%" + param.getTitle() + "%")
				.addCondition(param.getHouseType().getId() != 0, "houseType=?", param.getHouseType())
				.addCondition("area>=?", param.getMinArea())
				.addCondition("area<=?", param.getMaxArea())
				.addCondition("price>=?", param.getMinPrice())
				.addCondition("price<=?", param.getMaxPrice())
				.addOrderBy("pubDate", false);
		return houseDao.findByQueryAndPage(queryBean, page, size);
	}
	
}
