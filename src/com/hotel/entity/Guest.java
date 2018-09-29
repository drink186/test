package com.hotel.entity;

import java.io.Serializable;

public class Guest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2625185342657876000L;
	private int id;
	private String  name;
	private String idcard;
	private Room   room;
	private String inDate;
	private String outDate;
	private Double deposit;
	private Double amount;
	
	public Guest() {
		super();
	}
	
	public Guest(String name, String idcard, Room room, String inDate, Double deposit) {
		super();
		this.name = name;
		this.idcard = idcard;
		this.room = room;
		this.inDate = inDate;
		this.deposit = deposit;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
