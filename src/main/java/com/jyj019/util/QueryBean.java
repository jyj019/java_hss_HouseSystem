package com.jyj019.util;

import java.util.List;

import com.jyj019.util.QueryBean;

/**
 * 查询对象接口(把查询条件排序条件封装到一个接口中)
 * @author jyj019
 *
 */
public interface QueryBean {
	/**
	 * 查询条件对应的参数
	 * @return
	 */
	List<Object> getParameters();
	/**
	 * 添加排序关键字
	 * @param flag 标记
	 * @param keyword 关键字
	 * @param asc 排序顺序
	 * @return
	 */
	QueryBean addOrderBy(Boolean flag,String keyword,boolean asc);
	
	default QueryBean addOrderBy(String keyword,boolean asc) {
		return addOrderBy(true,keyword,asc);
	};

	default QueryBean addOrderBy(String keyword) {
		return addOrderBy(keyword,true);
	};
	
	QueryBean addCondition(boolean flag,String condition,Object value);
	
	default QueryBean addCondition(String condition, Object value) {
		return addCondition(true, condition, value);
	}
	
	/**
	 * 获得查询语句
	 * @return
	 */
	String getQueryString();
	/**
	 * 获得查询记录数语句
	 * @return
	 */
	String getCountString();
}
