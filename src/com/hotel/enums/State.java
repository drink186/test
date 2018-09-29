package com.hotel.enums;

public enum State {
	FULL(1, "Èë×¡"), 
	EMPTY(2, "¿ÕÏĞ"), 
	REPAIR(3, "Î¬ĞŞ");
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
