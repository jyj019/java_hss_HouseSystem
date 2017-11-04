package com.jyj019.persistence;

import com.jyj019.domain.House;
import com.jyj019.dto.PageBean;
import com.jyj019.util.QueryBean;
/**
 *
 *@Author jyj019
 **/
public interface HouseDao extends BaseDao<House, Integer> {
	
	PageBean<House> findByPage(int page,int size);
	
	PageBean<House> findByQueryAndPage(QueryBean queryBean,int page,int size);
}
