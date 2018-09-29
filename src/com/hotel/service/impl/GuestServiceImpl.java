package com.hotel.service.impl;

import java.util.List;

import com.hotel.dao.GuestDao;
import com.hotel.dao.RoomDao;
import com.hotel.dao.impl.GuestDaoImpl;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.entity.Guest;
import com.hotel.entity.Room;
import com.hotel.service.IGuestService;

public class GuestServiceImpl implements IGuestService{
    private GuestDao guestDao = new GuestDaoImpl();
    private RoomDao roomDao=new RoomDaoImpl();
	@Override
	public List<Guest> findAll() throws Exception {
		return guestDao.findAll();
	}
	@Override
	public int regist(Guest guest) throws Exception {
		//登记客人信息
		int key=guestDao.save(guest);
		//修改客房状态
		roomDao.update(guest.getRoom().getNumber(),guest.getRoom().getRoomState().getId(), guest.getRoom().getId());
		return key;
	}
	@Override
	public Guest findById(int id) throws Exception {
		Guest guest=new Guest();
		List<Guest> list =guestDao.findById(id);
		if(list!=null) {
			guest=list.get(0);
		}
		return guest;
	}
	@Override
	public List<Guest> findAnd(String name, int room, int currentPage, int pageSize) throws Exception {
		int start=(currentPage-1)*pageSize;
		return guestDao.findAnd(name, room, start, pageSize);
	}
	@Override
	public int count(String name, int room) throws Exception {
		return guestDao.count(name, room);
	}

}
