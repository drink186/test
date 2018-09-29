package com.hotel.service;

import java.util.List;

import com.hotel.entity.User;

public interface IUserService {
	/**
	 * ��¼
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> login(String login,String password) throws Exception;
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int regist(User user) throws Exception; 
}
