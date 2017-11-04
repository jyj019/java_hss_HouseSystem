package com.jyj019.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jyj019.service.HouseService;
import com.jyj019.service.LocationService;
/**
 *
 *@Author jyj019
 **/
public class PreLoadDataListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		WebApplicationContext wac = 
				WebApplicationContextUtils.getWebApplicationContext(sc);
		HouseService houseService = wac.getBean(HouseService.class);
		LocationService locationService = wac.getBean(LocationService.class);
		sc.setAttribute("houseTypeList", houseService.listAllHouseTypes());
		sc.setAttribute("provinceList", locationService.listAllProvinces());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().removeAttribute("houseTypeList");
		sce.getServletContext().removeAttribute("provinceList");
	}


}
