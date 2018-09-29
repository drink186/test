package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.RoomDao;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.entity.Room;
import com.hotel.service.IRoomService;

public class RoomServiceImpl implements IRoomService{
    private RoomDao roomDao=new RoomDaoImpl();
	@Override
	public List<Room> findByRoomType(int roomType, int state) throws Exception {
		return roomDao.findByRoomType(roomType, state);
	}
	@Override
	public List<Room> findAll(int currentPage, int pageSize) throws Exception {
		int start=(currentPage-1)*pageSize;
		return roomDao.findAll(start, pageSize);
	}
	@Override
	public int count() throws Exception {
		return roomDao.count();
	}
	@Override
	public int update(int number, int state, int id) throws Exception {
		return roomDao.update(number, state, id);
	}
	@Override
	public int update(String description, int type, int id) throws Exception {
		return roomDao.update(description, type, id);
	}
	@Override
	public int add(Room room) throws Exception {
		return roomDao.save(room);
	}
	@Override
	public Room findById(int id) throws Exception {
		return roomDao.findById(id).get(0);
	}
	@Override
	public List<Room> findAll() throws Exception {
		return roomDao.findAll();
	}
	
}
