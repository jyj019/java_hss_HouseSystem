package com.jyj019.util;

import java.util.ArrayList;
import java.util.List;


public class HQLQueryBean implements QueryBean {
	
	private String fromClouse;
	private String whereClouse;
	private String orderByClouse;
	
	private List<Object> paramValues= new ArrayList<>();
	
	public HQLQueryBean(Class<?> entityType) {
		fromClouse="from"+entityType.getSimpleName()+"as o";
	}
	
	@Override
	public QueryBean addOrderBy(Boolean flag, String keyword, boolean asc) {
		if (orderByClouse==null) {
			orderByClouse+="order by o."+keyword+(asc?"asc ":"desc ");
		}else {
			orderByClouse+=" ,o."+keyword+(asc?"asc ":"desc ");
		}
		return this;
	}

	@Override
	public QueryBean addCondition(boolean flag, String condition, Object value) {
		if (flag) {
			if (whereClouse == null) {
				whereClouse = "where o." + condition;
			} else {
				whereClouse = "and o." + condition;
			}
			paramValues.add(value);
		}
		return this;
	}


	@Override
	public String getQueryString() {
		return "from" +fromClouse+""+whereClouse;
	}

	@Override
	public String getCountString() {
		
		return "Select count(o)" +fromClouse+""+whereClouse;
	}

	@Override
	public List<Object> getParameters() {
		return paramValues;
	}



}
