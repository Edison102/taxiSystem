package com.sfu.dao;

import java.util.List;

import com.sfu.beans.User;

public interface UserDao {
	
	User queryUserByNameAndPwd(User user);
	User queryUserByName(User user);
	
	User queryUserById(Integer id);
	List<User> queryAllUser();
	
	void modifyUseryId(User user);
	
	void addUser(User user);
}
