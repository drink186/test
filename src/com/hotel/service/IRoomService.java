package com.hotel.service;

import java.util.List;

import com.hotel.entity.Room;

public interface IRoomService {
	/**
	 * ���ͷ����ͺ�״̬��ѯ
	 * @param roomType
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findByRoomType(int roomType,int state) throws Exception;
	/**
	 * ��ѯ���з���
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll() throws Exception;
	/**
	 * ��ѯ���з���
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll(int currentPage,int pageSize) throws Exception;
	/**
	 * ͳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;
	/**
	 * �޸���ס״̬����ס����
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public int update(int number,int state,int id) throws Exception;
	/**
	 * �޸Ŀͷ���Ϣ
	 * @param description
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public int update(String description,int type,int id) throws Exception;
	/**
	 * ��ӿͷ�
	 * @param room
	 * @return
	 * @throws Exception
	 */
	public int add(Room room)throws Exception;
	/**
	 * ����Ų�ѯ�ͷ���Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Room findById(int id) throws Exception;


}
