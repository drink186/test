package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Room;

public interface RoomDao {
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
	 * @param roomType
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public List<Room> findAll(int start,int pageSize) throws Exception;
	/**
	 * ͳ����ҳ��
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception;
	/**
	 * ����Ų�ѯ�ͷ���Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Room> findById(int id) throws Exception;
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
	public int save(Room room)throws Exception;
	

	
	
}
