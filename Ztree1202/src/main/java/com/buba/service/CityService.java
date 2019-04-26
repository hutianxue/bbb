package com.buba.service;

import java.util.List;



import com.buba.bean.City;

public interface CityService {
	List<City> findCity(int pi);
	int findCh(int pi);
	boolean addCity(City city);
	boolean delCity(int id);
	boolean updateCity(String name,int id);
}
