package com.example.car.model;


public class Car {
	
	private int 	CarID;
	private String 	CarName;
	private String 	CarBrand;
	private int		CarPrice;
	
	public int getCarID() {
		return CarID;
	}
	public void setCarID(int id) {
		this.CarID = id;
	}
	public String getCarBrand() {
		return CarBrand;
	}
	public void setCarBrand(String brand) {
		this.CarBrand = brand;
	}
	public int getCarPrice() {
		return CarPrice;
	}
	public void setCarPrice(int price) {
		this.CarPrice = price;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String name) {
		this.CarName = name;
	}

}
