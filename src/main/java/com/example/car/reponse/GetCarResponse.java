package com.example.car.reponse;

import java.util.ArrayList;
import java.util.List;

public class GetCarResponse {
	private List<GetCarDetailResponse> carList = new ArrayList<GetCarDetailResponse>();

	public List<GetCarDetailResponse> getCarList() {
		return carList;
	}

	public void setCarList(List<GetCarDetailResponse> carList) {
		this.carList = carList;
	}

}
