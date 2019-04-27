package com.buba.service;

import java.util.List;
import com.buba.bean.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	//查询用户信息
	PageInfo<User> findAll(int currentPageNo,int ccount);
	
	
	//统计部门平均薪资
	List<User> findMoney();
	
	//最高薪资
	List<User> findMaxMoney();
}
