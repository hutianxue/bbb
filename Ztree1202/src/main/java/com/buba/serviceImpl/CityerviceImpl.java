package com.buba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buba.bean.City;
import com.buba.dao.CityMapper;
import com.buba.service.CityService;
@Service
public class CityerviceImpl implements CityService {
	@Autowired
	private CityMapper cityMapper;
	@Override
	public List<City> findCity(int pi) {
	
		return cityMapper.findCity(pi);
	}
	@Override
	public int findCh(int pi) {
		// TODO Auto-generated method stub
		return cityMapper.findCh(pi);
	}
	@Override
	public boolean addCity(City city) {
		// TODO Auto-generated method stub
		return cityMapper.addCity(city);
	}
	@Override
	public boolean delCity(int id) {
		// TODO Auto-generated method stub
		return cityMapper.delCity(id);
	}
	@Override
	public boolean updateCity(String name, int id) {
		// TODO Auto-generated method stub
		return cityMapper.updateCity(name, id);
	}

}
