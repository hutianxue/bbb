package com.buba.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buba.dao.UserDAO;
import com.buba.pojo.User;
import com.buba.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public User finduser(String usercode, String password) {
		// TODO Auto-generated method stub
		return userDAO.finduser(usercode, password);
	}

}
