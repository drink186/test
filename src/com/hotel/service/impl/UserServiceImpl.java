package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.UserDao;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.User;
import com.hotel.service.IUserService;

public class UserServiceImpl implements IUserService {
	private UserDao userDao=new UserDaoImpl();

	@Override
	public List<User> login(String login, String password) throws Exception {
		return userDao.findByLoginAndPassword(login, password);
	}

	@Override
	public int regist(User user) throws Exception {
		return userDao.save(user);
	}
}
