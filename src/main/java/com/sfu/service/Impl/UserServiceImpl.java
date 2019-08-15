package com.sfu.service.Impl;

import java.util.List;

import com.sfu.beans.User;
import com.sfu.dao.UserDao;
import com.sfu.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private UserDao dao;
	
	

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User selectUserByNameAndPwd(User user) {
		return dao.queryUserByNameAndPwd(user);
	}

	@Override
	public User selectUserById(Integer id) {
		return dao.queryUserById(id);
	}

	@Override
	public List<User> selectAllUser() {
		return dao.queryAllUser();
	}

	@Override
	public void updateUseryId(User user) {
		dao.modifyUseryId(user);
	}

	@Override
	public void insertUser(User user) {
		dao.addUser(user);
	}

	@Override
	public User selectUserByName(User user) {
		return dao.queryUserByName(user);
	}

}
