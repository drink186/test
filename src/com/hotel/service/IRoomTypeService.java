package com.hotel.service;

import java.util.List;

import com.hotel.entity.RoomType;

public interface IRoomTypeService {
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
	public RoomType findById(int id) throws Exception;
	/**
	 * ��ӿͷ�����
	 * @param roomType
	 * @return
	 * @throws Exception
	 */
	public int add(RoomType roomType) throws Exception;

}
