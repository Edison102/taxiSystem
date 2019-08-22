package com.sfu.service.Impl;

import java.util.List;

import com.sfu.beans.User;
import com.sfu.dao.UserDao;
import com.sfu.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao dao;

	//private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User selectUserByNameAndPwd(User user) {
		//log.info("查找数据开始");
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
