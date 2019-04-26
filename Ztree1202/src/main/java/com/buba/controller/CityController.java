package com.buba.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.buba.bean.City;
import com.buba.service.CityService;

@RequestMapping("/city")
@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	
	@ResponseBody
	@RequestMapping("/findcity")
	public List<City> findCity(HttpServletRequest request,HttpServletResponse response,String id ) throws IOException{
		int pi=0;
		if(id!=null&&!"".equals(id)) {
			pi=Integer.parseInt(id);
		}
		/*int ch = cityService.findCh(pi);
		City ci=new City();
		boolean b=true;
		if(ch>=1) {
			b=true;
		}else {
			b=false;
		}
		ci.setIsParent(b);*/
		List<City> city = cityService.findCity(pi);
		System.out.println(111);
		return city;
		
	}
	@ResponseBody
	@RequestMapping("/addCity")
	public boolean addCity(City city,HttpServletResponse response) throws IOException {
		boolean b = cityService.addCity(city);
		boolean b1=false;
		if(b) {
			b1=true;
		}else {
			b1=false;
		}				
		return b1;
	}
	@ResponseBody
	@RequestMapping("/delCity")
	public boolean delCity(int id,HttpServletResponse response) throws IOException {
		boolean b = cityService.delCity(id);
		
		boolean b1=false;
		if(b) {
			b1=true;
		}else {
			b1=false;
		}
		return b1;
		
	}
	@ResponseBody
	@RequestMapping("/updateCity")
	public boolean updateCity(String name,int id,HttpServletResponse response) throws IOException {
		boolean b = cityService.updateCity(name, id);
		boolean b1=false;
		if(b) {
			b1=true;
		}else {
			b1=false;
		}				
		return b1;
	}
}
