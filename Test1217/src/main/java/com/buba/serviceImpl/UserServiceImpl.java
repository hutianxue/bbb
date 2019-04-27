package com.buba.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.buba.bean.User;
import com.buba.dao.UserMapper;
import com.buba.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findMoney() {
		// TODO Auto-generated method stub
		return userMapper.findMoney();
	}
	@Override
	public List<User> findMaxMoney() {
		// TODO Auto-generated method stub
		return userMapper.findMaxMoney();
	}
	@Override
	public PageInfo<User> findAll(int currentPageNo, int ccount) {
		PageHelper.startPage(currentPageNo, ccount);
		
		List<User> user = userMapper.findAll();
		 
		PageInfo<User> pa=new PageInfo<>(user);

		return pa;
	}

}
