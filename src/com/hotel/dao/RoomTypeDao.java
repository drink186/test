package com.hotel.dao;

import java.util.List;

import com.hotel.entity.RoomType;

public interface RoomTypeDao {
	/**
	 * ��ѯ��������
	 * @return
	 * @throws Exception
	 */
	public List<RoomType> findAll() throws Exception;
	/**
	 * ����Ų�ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<RoomType> findById(int id) throws Exception;
	/**
	 * ��ӿͷ�����
	 * @param roomType
	 * @return
	 * @throws Exception
	 */
	public int save(RoomType roomType) throws Exception;
}
