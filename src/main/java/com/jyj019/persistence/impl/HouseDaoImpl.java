package com.jyj019.persistence.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jyj019.domain.House;
import com.jyj019.dto.PageBean;
import com.jyj019.persistence.HouseDao;
import com.jyj019.util.QueryBean;

@Repository
public class HouseDaoImpl extends BaseDaoAdapter<House, Integer> implements HouseDao {

	@Override
	public PageBean<House> findByPage(int page, int size) {
		//����1+N��ѯ����
		List<House> dataModel = sessionFactory.getCurrentSession()
				.createQuery("from House as h left join fetch h.houseType "
						+ " left join fetch h.district as d "
						+ " left join fetch d.city as c "
						+ " left join fetch c.province "
						+ " order by h.pubDate desc", House.class)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int count = sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h", Long.class)
				.getSingleResult().intValue();
		int totalPage = (count - 1) / size + 1;
		return new PageBean<>(dataModel, totalPage, page, size);
	}

	@Override
	public PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size) {
		//String hql = queryBean.getQueryString();
		Query query = sessionFactory.getCurrentSession().createQuery(queryBean.getQueryString());
		List<Object> paramValues = queryBean.getParameters();
		for (int i = 0; i <paramValues.size(); ++i) {
			query.setParameter(i, paramValues.get(i));
		}
		List<House> dataModel = query.setFirstResult((page - 1) * size).setMaxResults(size).getResultList();
		
		Iterator<House>  it=dataModel.iterator();
		while(it.hasNext()) {			
			System.out.println(it.next().toString());
		}
		
		query = sessionFactory.getCurrentSession().createQuery(queryBean.getCountString());
		for (int i = 0; i < paramValues.size(); ++i) {
			query.setParameter(i, paramValues.get(i));
		}
		int total = ((Long) (query.getSingleResult())).intValue();
		int totalPage = (total - 1) / size + 1;
		return new PageBean<>(dataModel, totalPage, page, size);
	}
		
}
