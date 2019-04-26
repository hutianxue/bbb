package com.buba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.buba.bean.City;

public interface CityMapper {
	
	List<City> findCity(int pi);
	
	int findCh(int pi);
	
	boolean addCity(City city);
	
	boolean delCity(int id);
	
	boolean updateCity(@Param("name")String name,@Param("id")int id);
}
