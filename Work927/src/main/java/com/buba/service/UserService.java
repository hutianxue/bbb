package com.buba.service;

import com.buba.pojo.User;

public interface UserService {
	public User finduser(String usercode,String password);
}
