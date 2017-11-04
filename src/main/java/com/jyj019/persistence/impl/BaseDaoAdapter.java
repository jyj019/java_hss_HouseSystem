package com.jyj019.persistence.impl;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jyj019.persistence.BaseDao;
/**
 * ?????? ????????????????????
 * @author jinyu
 *
 * @param <E> ????
 * @param <K> ????
 */

public abstract class BaseDaoAdapter<E,K extends Serializable> implements BaseDao<E,K> {

	private Class<?> entityType;
	private String entityName;
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected BaseDaoAdapter() {
		ParameterizedType pt=(ParameterizedType) this.getClass().getGenericSuperclass();
		entityType=(Class<E>) pt.getActualTypeArguments()[0];
		entityName=entityType.getSimpleName();
	}
	
	/**
	 * ???????
	 */
	@Override
	public K save(E entity) {
		return (K) sessionFactory.getCurrentSession().save(entity);
	}
	
	
	@Override
	public boolean delete(E entity) {		
		return sessionFactory.getCurrentSession()
				.createQuery("delete from"+entityName+"as  ")
				.executeUpdate()==1;
	}
	
	/**
	 * ???????????
	 */
	@Override
	public boolean deleteById(K id) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from"+entityName+"as o where o.id=:id")
				.setParameter("id", id)
				.executeUpdate()==1;
	}
	
	/**
	 * ???????
	 */
	@Override
	public E update(E entity) {		
		return (E) sessionFactory.getCurrentSession().merge(entity);
	}
	
	/**
	 * ???????????
	 */
	@Override
	public E findById(K id) {
		return  (E) sessionFactory.getCurrentSession().get(entityType, id);
	}
	
	/**
	 * ??????????
	 */
	@Override
	public List<E> findAll() {
		return (List<E>) sessionFactory.getCurrentSession()
				.createQuery("from "+entityName,entityType)
				.getResultList();
	}
	
}
