package com.hotel.dao.impl;

import java.util.List;

import org.jbit.dao.BaseDao;

import com.hotel.dao.RoomTypeDao;
import com.hotel.entity.RoomType;

public class RoomTypeDaoImpl extends BaseDao implements RoomTypeDao {

	@Override
	public List<RoomType> findAll() throws Exception {
		String sql="SELECT t_id id,t_name name FROM t_type";
		List<RoomType> list=this.executeQuery(sql, null, RoomType.class);
		return list;
	}

	@Override
	public int save(RoomType roomType) throws Exception {
		String sql="INSERT INTO t_type(t_id,t_name,t_beds,t_price) VALUES(?,?,?,?)";
		Object[] params= {roomType.getId(),roomType.getName(),
				roomType.getBeds(),roomType.getPrice()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<RoomType> findById(int id) throws Exception {
		String sql="SELECT t_id id,t_name name FROM t_type WHERE t_id=?";
		Object[] params= {id};
		List<RoomType> list=this.executeQuery(sql, params, RoomType.class);
		return list;
	}

}
