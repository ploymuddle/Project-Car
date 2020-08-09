package com.example.car.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.car.reponse.DeleteCarResponse;
import com.example.car.reponse.GetCarResponse;
import com.example.car.reponse.InsertCarResponse;
import com.example.car.reponse.UpdateCarResponse;
import com.example.car.request.DeleteCarRequest;
import com.example.car.request.GetCarRequest;
import com.example.car.request.InsertCarRequest;
import com.example.car.request.UpdateCarRequest;


@Service
public interface CarService {

	public GetCarResponse getCar(GetCarRequest request) throws Exception  ;

	public UpdateCarResponse update(UpdateCarRequest request) throws Exception ;

	public InsertCarResponse insert(InsertCarRequest request) throws Exception ;

	public DeleteCarResponse delete(DeleteCarRequest request) throws Exception  ;
		
}
