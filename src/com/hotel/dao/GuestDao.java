package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Guest;

public interface GuestDao {
	/**
	 * ��ѯ����ס�޿���
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAll() throws Exception;
	/**
	 * ��������
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int save(Guest guest) throws Exception;
	/**
	 * ��������ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findById(int id) throws Exception;
	/**
	 * ��������ѯ
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int start,int pageSize) throws Exception;
	/**
	 * ͳ�Ƽ�¼��
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int count(String name,int room) throws Exception;

}
