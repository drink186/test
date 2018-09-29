package com.hotel.enums;

public enum State {
	FULL(1, "��ס"), 
	EMPTY(2, "����"), 
	REPAIR(3, "ά��");
	private int id;
	private String desc;

	State(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
}
