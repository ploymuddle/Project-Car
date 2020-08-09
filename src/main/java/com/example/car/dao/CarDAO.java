package com.example.car.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.car.model.Car;


@Repository
public interface CarDAO {
	
//	public boolean checkId(int id) ;
//	public List<Car> find() ;
	public List<Car> find(Car findObject) throws Exception ;
	public void update(Car updateObject) ;
	public void insert(Car insertObject) ;
	public void delete(int id) ;
	public List<Car> getID() ;

}