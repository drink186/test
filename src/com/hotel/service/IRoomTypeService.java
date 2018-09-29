package com.hotel.service;

import java.util.List;

import com.hotel.entity.RoomType;

public interface IRoomTypeService {
	/**
	 * 查询所有数据
	 * @return
	 * @throws Exception
	 */
	public List<RoomType> findAll() throws Exception;
	/**
	 * 按编号查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RoomType findById(int id) throws Exception;
	/**
	 * 添加客房类型
	 * @param roomType
	 * @return
	 * @throws Exception
	 */
	public int add(RoomType roomType) throws Exception;

}
