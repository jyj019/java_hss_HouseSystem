package com.jyj019.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具�?
 * @author jinyu
 *
 */
public final class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		factory=new Configuration().configure().buildSessionFactory();
	}
	
	private HibernateUtil(){
		throw new AssertionError();
	}
	/**
	 * 获得与上下文相关联的session对象
	 * @return
	 */
	public static Session getSession() {
		return factory.getCurrentSession();
	}
}
