package com.jyj019.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyj019.domain.City;
import com.jyj019.domain.District;
import com.jyj019.domain.House;
import com.jyj019.domain.Province;
import com.jyj019.dto.PageBean;
import com.jyj019.dto.searchHouseParam;
import com.jyj019.service.HouseService;
import com.jyj019.service.LocationService;


/**
 * 首页的控制器 包括分页显示 前往其他类
 * @Author jyj019
 */

@Controller
@RequestMapping("/")//映射首页
public class HomeController {
	
	@Autowired
	private LocationService locationService;
	@Autowired
	private HouseService houseService;
	
	@GetMapping("/searchHouse")
	public String searchHouse(searchHouseParam param,
			@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int size,
			Model model){
		PageBean<House> pageBean = 
				houseService.searchHouseWithParamByPage(param, page, size);
		Iterator<House>  it=pageBean.getDataModel().iterator();
		while(it.hasNext()) {			
			System.out.println(it.next().toString());
		}
		
		
		model.addAttribute("houseList", pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		return "index";
	}
	
	@GetMapping({"/","/home"})
	public String toIndex(@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int size,
			Model model){
		PageBean<House> pageBean = houseService.listHousesByPage(page, size);
		
		model.addAttribute("houseList", pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		
		return "index";
	}
	
	@GetMapping("/topub")
	public String toPub() {		
		return "pub";
	}
	
	@GetMapping("/cities")
	@ResponseBody
	public List<City> getCities(Province province) {
		return locationService.listAllCitiesByProvince(province);
	}
	
	@GetMapping("/districts")
	@ResponseBody
	public List<District> getDistricts(City city) {
		return locationService.listAllDistrictsByCity(city);
	}
	
	@GetMapping("/tologin")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping("/toregister")
	public String toRegister() {
		return "register";
	}
}
