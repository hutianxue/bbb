package com.buba.service;



import com.buba.bean.Dept;

import com.github.pagehelper.PageInfo;

public interface DepeService {
	PageInfo<Dept> findAll(int currentPageNo,int ccount);
}
