package com.buba.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buba.pojo.User;
import com.buba.service.UserService;
@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//登录
	@RequestMapping("/login")
	public String login(String usercode,String password,HttpServletRequest request) {
		User user = userService.finduser(usercode, password);
		HttpSession session = request.getSession();
		if(user!=null) {
			session.setAttribute("user", user);
			return "show";
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			return "../login";
		}		
	}
	//登出
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "../login";
	}
}
