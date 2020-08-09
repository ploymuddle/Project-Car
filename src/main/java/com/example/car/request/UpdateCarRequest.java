package com.example.car.request;

public class UpdateCarRequest {
	private String 	carID;
	private String 	carName;
	private String 	carBrand;
	private String	carPrice;

	public String getCarID() {
		return carID;
	}
	public void setCarID(String id) {
		this.carID = id;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String brand) {
		this.carBrand = brand;
	}
	public String getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(String price) {
		this.carPrice = price;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String name) {
		this.carName = name;
	}
	
	public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
