package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Room;

public interface RoomDao {
	/**
	 * 按客房类型和状态查询
	 * @param roomType
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findByRoomType(int roomType,int state) throws Exception;
	/**
	 * 查询所有房间
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll() throws Exception;
	/**
	 * 查询所有房间
	 * @param roomType
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll(int start,int pageSize) throws Exception;
	/**
	 * 统计总页数
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;
	/**
	 * 按编号查询客房信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Room> findById(int id) throws Exception;
	/**
	 * 修改入住状态及入住人数
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public int update(int number,int state,int id) throws Exception;
	/**
	 * 修改客房信息
	 * @param description
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public int update(String description,int type,int id) throws Exception;
	/**
	 * 添加客房
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int save(Room room)throws Exception;
	

	
	
}
