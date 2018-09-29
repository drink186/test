package com.hotel.dao;

import java.util.List;

import com.hotel.entity.User;

public interface UserDao {
	/**
	 * ����¼���������ѯ
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> findByLoginAndPassword(String login,String password) throws Exception;
	/**
	 * ��Ӽ�����
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int save(User user) throws Exception;
}
