package com.example.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.car.dao.CarDAO;
import com.example.car.model.Car;
import com.example.car.reponse.DeleteCarResponse;
import com.example.car.reponse.GetCarResponse;
import com.example.car.reponse.InsertCarResponse;
import com.example.car.reponse.UpdateCarResponse;
import com.example.car.request.DeleteCarRequest;
import com.example.car.request.GetCarRequest;
import com.example.car.request.InsertCarRequest;
import com.example.car.request.UpdateCarRequest;
import com.example.car.service.CarService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {

    @Autowired
    public CarDAO dao;
    
    @Autowired
	private CarService carService;
    
    List<Car> responseCar = null;    
    
    @PostMapping("/getCar")
    public GetCarResponse getCar(@RequestBody GetCarRequest request ) throws Exception  {
    	GetCarResponse response = new GetCarResponse();
		response = carService.getCar(request);
    	return response;
    }
 
    @PostMapping("/updateCar") 
    public UpdateCarResponse updateCar(@RequestBody UpdateCarRequest request ) throws Exception {
    	UpdateCarResponse response = new UpdateCarResponse();
    	response = carService.update(request);
    	return response; 
    }

    @PostMapping("/insertCar")
    public InsertCarResponse insertCar(@RequestBody InsertCarRequest request ) throws Exception  {
    	InsertCarResponse response = new InsertCarResponse();
    	response = carService.insert(request);
    	return response;
    }
    
    @PostMapping("/deleteCar")
    public DeleteCarResponse deleteCar(@RequestBody DeleteCarRequest request ) throws Exception{
    	DeleteCarResponse response = new DeleteCarResponse();
    	response = carService.delete(request);
    	return response;	
    }
}