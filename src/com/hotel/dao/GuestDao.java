package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Guest;

public interface GuestDao {
	/**
	 * 查询所有住宿客人
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAll() throws Exception;
	/**
	 * 插入数据
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int save(Guest guest) throws Exception;
	/**
	 * 按主键查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findById(int id) throws Exception;
	/**
	 * 按条件查询
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int start,int pageSize) throws Exception;
	/**
	 * 统计记录数
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int count(String name,int room) throws Exception;

}
