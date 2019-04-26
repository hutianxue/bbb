package com.buba.dao;

import com.buba.pojo.User;

public interface UserDAO {
	public User finduser(String usercode,String password);
}
