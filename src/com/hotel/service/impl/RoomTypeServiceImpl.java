package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.RoomTypeDao;
import com.hotel.dao.impl.RoomTypeDaoImpl;
import com.hotel.entity.RoomType;
import com.hotel.service.IRoomTypeService;

public class RoomTypeServiceImpl implements IRoomTypeService {
    private RoomTypeDao roomTypeDao=new RoomTypeDaoImpl();
	@Override
	public List<RoomType> findAll() throws Exception {
		return roomTypeDao.findAll();
	}
	@Override
	public int add(RoomType roomType) throws Exception {
		return roomTypeDao.save(roomType);
	}
	@Override
	public RoomType findById(int id) throws Exception {
		return roomTypeDao.findById(id).get(0);
	}

}
