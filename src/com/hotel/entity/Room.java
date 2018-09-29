package com.hotel.entity;

public class Room {
	private Integer id;
	private String description;
	private RoomType roomType;
	private RoomState roomState;
	private Integer number;
	
	public Room() {
		super();
	}
	

	public Room(String description, RoomType roomType) {
		super();
		this.description = description;
		this.roomType = roomType;
	}


	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}


	public RoomState getRoomState() {
		return roomState;
	}


	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public String toString() {
		return this.getRoomType().getName();
	}
	

}
