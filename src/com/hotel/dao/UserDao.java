package com.hotel.dao;

import java.util.List;

import com.hotel.entity.User;

public interface UserDao {
	/**
	 * 按登录名和密码查询
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> findByLoginAndPassword(String login,String password) throws Exception;
	/**
	 * 添加加数据
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int save(User user) throws Exception;
}
