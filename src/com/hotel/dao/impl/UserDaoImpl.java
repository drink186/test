package com.hotel.dao.impl;

import java.util.List;

import org.jbit.dao.BaseDao;

import com.hotel.dao.UserDao;
import com.hotel.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> findByLoginAndPassword(String login, String password) throws Exception {
		String sql="SELECT u_login login,u_password password FROM t_user WHERE u_login=? AND u_password=?";
		Object[] params= {login,password}; 
		List<User> list=this.executeQuery(sql, params, User.class);
		return list;
	}

	@Override
	public int save(User user) throws Exception {
		String sql="INSERT INTO t_user(u_login,u_password) VALUES(?,?)";
		Object[] params= {user.getLogin(),user.getPassword()}; 
		return executeUpdate(sql, params);
	}

}
