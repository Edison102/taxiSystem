package com.sfu.service;

import java.util.List;

import com.sfu.beans.User;

public interface IUserService {
	
	User selectUserByNameAndPwd(User user);
	User selectUserByName(User user);
	
	User selectUserById(Integer id);
	List<User> selectAllUser();
	
	void updateUseryId(User user);
	
	void insertUser(User user);
}
