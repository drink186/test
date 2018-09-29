package com.hotel.entity;

public class RoomType {
	private Integer id;
	private String name;
	private Integer beds;
	private Double price;
	
	public RoomType() {
		super();
	}
	
	public RoomType(Integer id, String name, Integer beds, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.beds = beds;
		this.price = price;
	}

	public Integer getBeds() {
		return beds;
	}
	public void setBeds(Integer beds) {
		this.beds = beds;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
