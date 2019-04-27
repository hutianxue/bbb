package com.buba.dao;

import java.util.List;

import com.buba.bean.User;

public interface UserMapper {
	//查询用户信息
	List<User> findAll();
	
	//统计部门平均薪资
	List<User> findMoney();
	
	//最高薪资
	List<User> findMaxMoney();
	
	
}
