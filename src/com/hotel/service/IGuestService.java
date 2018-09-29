package com.hotel.service;

import java.util.List;

import com.hotel.entity.Guest;
import com.hotel.entity.Room;

public interface IGuestService {
	/**
	 * ��ѯ����ס�޿���
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAll() throws Exception;
	/**
	 * ��ס�Ǽ�
	 * @param guest
	 * @return
	 * @throws Exception
	 */
	public int regist(Guest guest) throws Exception;
	/**
	 * ��������ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Guest findById(int id) throws Exception;
	/**
	 * ��������ѯ
	 * @return
	 * @throws Exception
	 */
	public List<Guest> findAnd(String name,int room,int currentPage,int pageSize) throws Exception;
	/**
	 * ͳ�Ƽ�¼��
	 * @param name
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int count(String name,int room) throws Exception;


}
