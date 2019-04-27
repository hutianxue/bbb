package com.buba.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buba.bean.Dept;
import com.buba.dao.DeptMapper;
import com.buba.service.DepeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class DeptServiceImpl implements DepeService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public PageInfo<Dept> findAll(int currentPageNo, int ccount) {
		PageHelper.startPage(currentPageNo, ccount);
		List<Dept> allDept = deptMapper.findAllDept();
		PageInfo<Dept> pa= new PageInfo<Dept>(allDept);
		return pa;
	}
	

}
