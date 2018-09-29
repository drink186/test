package com.hotel.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jbit.dao.BaseDao;

import com.hotel.dao.GuestDao;
import com.hotel.entity.Guest;

public class GuestDaoImpl extends BaseDao implements GuestDao{

	@Override
	public List<Guest> findAll() throws Exception {
		String sql="SELECT a.g_name name,a.g_idcard idcard,a.g_deposit deposit," + 
				"a.g_in_date inDate, b.r_description 'room.description' " + 
				"FROM t_guest a JOIN t_room b ON(a.g_room=b.r_id)";
		List<Guest> list=this.executeQuery(sql, null, Guest.class);
		return list;
	}

	@Override
	public int save(Guest guest) throws Exception {
		String sql="INSERT INTO t_guest(g_name,g_idcard,g_deposit,g_in_date,g_room)"+
				" VALUES(?,?,?,?,?)";
		Object[] params= {guest.getName(),guest.getIdcard(),guest.getDeposit(),guest.getInDate(),guest.getRoom().getId()};
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<Guest> findById(int id) throws Exception {
		String sql="SELECT a.g_name name,a.g_idcard idcard,a.g_deposit deposit," + 
				"a.g_in_date inDate, b.r_description 'room.description' " + 
				"FROM t_guest a JOIN t_room b ON(a.g_room=b.r_id) " +
				"WHERE g_id=?";
		Object[] params= {id};
		List<Guest> list=this.executeQuery(sql, params, Guest.class);
		return list;
	}

	@Override
	public List<Guest> findAnd(String name, int room, int start, int pageSize) throws Exception {
		String sql1=" AND a.g_name LIKE CONCAT('%',?,'%')";
		String sql2=" AND a.g_room=?";
		String pageSql=" LIMIT ?,?";
		String sql="SELECT a.g_name name,a.g_idcard idcard,a.g_out_date outDate," + 
				"a.g_in_date inDate, b.r_description 'room.description',g_amount amount " + 
				"FROM t_guest a JOIN t_room b ON(a.g_room=b.r_id) " +
				"WHERE 1=1";
		List params=new ArrayList();
		if(name!=null&&name.length()>0) {
			sql=sql+sql1;
			params.add(name);
		}
		if(room>0){
			sql=sql+sql2;
			params.add(room);
		}
		sql+=pageSql;
		params.add(start);
		params.add(pageSize);
		
		List<Guest> list=this.executeQuery(sql, params.toArray(), Guest.class);
		return list;
	}

	@Override
	public int count(String name, int room) throws Exception {
		String sql="SELECT count(g_id) FROM t_guest WHERE 1=1";
		String sql1=" AND g_name LIKE CONCAT('%',?,'%')";
		String sql2=" AND g_room=?";
		List params=new ArrayList();
		if(name!=null&&name.length()>0) {
			sql=sql+sql1;
			params.add(name);
		}
		if(room>0){
			sql=sql+sql2;
			params.add(room);
		}
		return this.executeCount(sql, params.toArray());
	}

	
	

}
