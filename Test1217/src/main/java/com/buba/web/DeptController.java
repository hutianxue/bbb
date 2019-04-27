package com.buba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buba.bean.Dept;
import com.buba.service.DepeService;
import com.github.pagehelper.PageInfo;
@RequestMapping("/dept")
@Controller
public class DeptController {
	@Autowired
	private DepeService depeService;
	@RequestMapping("/findAllDept/{currentPageNo}/{ccount}")
	public String findAllDept(@PathVariable()int currentPageNo,@PathVariable()int ccount,Model model) {
		PageInfo<Dept> findAll = depeService.findAll(currentPageNo, ccount);
		model.addAttribute("p", findAll);
		return "deptlist";
	}
}
