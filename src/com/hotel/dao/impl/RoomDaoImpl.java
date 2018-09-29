package com.hotel.dao.impl;

import java.util.List;

import org.jbit.dao.BaseDao;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Room;

public class RoomDaoImpl extends BaseDao implements RoomDao{

	@Override
	public List<Room> findByRoomType(int roomType, int state) throws Exception {
		String sql="SELECT r_id id,r_description description " + 
				"FROM t_room " + 
				"WHERE r_type=? AND r_state=?";
		Object[] params= {roomType,state};
		return this.executeQuery(sql, params, Room.class);
	}

	

	@Override
	public int update(int number,int state,int id) throws Exception {
		String sql="UPDATE t_room SET r_number=?,r_state=? WHERE r_id=?";
		Object[] params= {number,state,id};
		return this.executeUpdate(sql, params);
	}



	@Override
	public List<Room> findAll(int start,int pageSize) throws Exception {
		String sql="SELECT a.r_id id,a.r_description description," + 
				"a.r_number number,b.t_name 'roomType.name'," + 
				"c.s_name 'roomState.name' FROM t_room a,t_type b," + 
				"t_state c WHERE a.r_type=b.t_id AND a.r_state=c.s_id" +
				" ORDER BY a.r_id DESC LIMIT ?,?";
		Object[] params= {start,pageSize};
		return this.executeQuery(sql, params, Room.class);
	}

	@Override
	public int count() throws Exception {
		String sql="SELECT COUNT(r_id) FROM t_room";
		return this.executeCount(sql, null);
	}



	@Override
	public int update(String description, int type, int id) throws Exception {
		String sql="UPDATE t_room SET r_description=?,r_type=? WHERE r_id=?";
		Object[] params= {description,type,id};
		return this.executeUpdate(sql, params);
	}



	@Override
	public int save(Room room) throws Exception {
		String sql="INSERT INTO t_room(r_description,r_type) VALUES(?,?)";
		Object[] params= {room.getDescription(),room.getRoomType().getId()};
		return this.executeUpdate(sql, params);
	}



	@Override
	public List<Room> findById(int id) throws Exception {
		String sql="SELECT r_id id,"
				+ "r_description description,"
				+ "r_type 'roomType.id'"
				+ " FROM t_room WHERE r_id=?";
		Object[] params= {id};
		return this.executeQuery(sql, params, Room.class);
	}



	@Override
	public List<Room> findAll() throws Exception {
		String sql="SELECT r_id id,r_description description "
				+ "FROM t_room";
		return this.executeQuery(sql, null, Room.class);
	}

}
