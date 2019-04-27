package com.buba.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buba.bean.User;
import com.buba.service.UserService;
import com.github.pagehelper.PageInfo;
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll/{currentPageNo}/{ccount}")
	public String findAll(@PathVariable()int currentPageNo,@PathVariable()int ccount,Model model) {
		PageInfo<User> findAll = userService.findAll(currentPageNo, ccount);
		model.addAttribute("p", findAll);
		return "userlist";
	}
	
	@ResponseBody
	@RequestMapping("/findMoney")
	public List<User> findMoney() {
		List<User> money = userService.findMoney();
		return money;
	}
	
	@ResponseBody
	@RequestMapping("/findMaxMoney")
	public List<User> findMaxMoney() {
		List<User> maxMoney = userService.findMaxMoney();
		return maxMoney;
	}
}
