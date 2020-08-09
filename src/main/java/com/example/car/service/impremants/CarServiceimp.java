package com.example.car.service.impremants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.car.dao.CarDAO;
import com.example.car.exception.ServiceValidation;
import com.example.car.model.Car;
import com.example.car.reponse.DeleteCarResponse;
import com.example.car.reponse.GetCarDetailResponse;
import com.example.car.reponse.GetCarResponse;
import com.example.car.reponse.InsertCarResponse;
import com.example.car.reponse.UpdateCarResponse;
import com.example.car.request.DeleteCarRequest;
import com.example.car.request.GetCarRequest;
import com.example.car.request.InsertCarRequest;
import com.example.car.request.UpdateCarRequest;
import com.example.car.service.CarService;
import com.example.car.util.IntegerUtil;
import com.example.car.util.StringUtils;

@Service
public class CarServiceimp implements CarService {

	@Autowired
	private CarDAO dao;

	@Override
	public GetCarResponse getCar(GetCarRequest request) throws Exception {
		GetCarResponse response = new GetCarResponse();
		Car car = new Car();
		List<Car> cars = new ArrayList<>();
		List<GetCarDetailResponse> carDetailList = new ArrayList<>();
//All
//		if(StringUtils.isNotEmptyOrNull(request.getCarID())) {
//			
//			if(request.getCarID().equals("All")){
//			cars = dao.find();
//		}
//		car.setCarID(Integer.parseInt(request.getCarID()));

		try {
			if (StringUtils.isNotEmptyOrNull(request.getCarID())) {
				if (IntegerUtil.isInteger(request.getCarID())) {
					car.setCarID(Integer.valueOf(request.getCarID()));
				} else {
					throw new ServiceValidation("isNotInteger");
				}
			}

			cars = dao.find(car);
			if (!cars.isEmpty()) {

				for (int i = 0; i < cars.size(); i++) {
					GetCarDetailResponse carDetails = new GetCarDetailResponse();
					carDetails.setCarID(cars.get(i).getCarID());
					carDetails.setCarName(cars.get(i).getCarName());
					carDetails.setCarBrand(cars.get(i).getCarBrand());
					carDetails.setCarPrice(cars.get(i).getCarPrice());
					carDetailList.add(carDetails);
				}
			} else {
				throw new ServiceValidation("isNotEmpty");
			}
			response.setCarList(carDetailList);
		} catch (ServiceValidation e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return response;

	}

	@Override
	public UpdateCarResponse update(UpdateCarRequest request) throws Exception {
		UpdateCarResponse response = new UpdateCarResponse();
		Car car = new Car();
		List<Car> cars = new ArrayList<Car>();
		try {
			if (StringUtils.isNotEmptyOrNull(request.getCarID())) {
				if (IntegerUtil.isInteger(request.getCarID())) {
					car.setCarID(Integer.valueOf(request.getCarID()));
				} else {
					throw new ServiceValidation("isNotInteger");
				}
				cars = dao.find(car);
				if (!cars.isEmpty()) {
					for (int i = 0; i < cars.size(); i++) {
						car.setCarID(cars.get(i).getCarID());
						car.setCarName(cars.get(i).getCarName());
						car.setCarBrand(cars.get(i).getCarBrand());
						car.setCarPrice(cars.get(i).getCarPrice());
					}

					if (StringUtils.isNotEmptyOrNull(request.getCarName())) {
						car.setCarName(request.getCarName());
					}
					if (StringUtils.isNotEmptyOrNull(request.getCarBrand())) {
						car.setCarBrand(request.getCarBrand());
					}
					if (StringUtils.isNotEmptyOrNull(request.getCarPrice())) {
						car.setCarPrice(Integer.parseInt(request.getCarPrice()));
					}
					dao.update(car);
					response.setStatus("success");
				} else {
					throw new ServiceValidation("CarID don't have " + request.getCarID());
				}
			} else {
				throw new ServiceValidation("isNotEmptyOrNull");
			}
		} catch (ServiceValidation e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

		return response;
	}

	@Override
	public InsertCarResponse insert(InsertCarRequest request) throws Exception {
		InsertCarResponse response = new InsertCarResponse();

		Car car = new Car();
		List<Car> cars = new ArrayList<Car>();
		try {
			if (request != null) {
				if (StringUtils.isNotEmptyOrNull(request.getCarName())) {
					car.setCarName(request.getCarName());
					if (StringUtils.isNotEmptyOrNull(request.getCarBrand())) {
						car.setCarBrand(request.getCarBrand());
						if (StringUtils.isNotEmptyOrNull(request.getCarPrice())) {
							car.setCarPrice(Integer.parseInt(request.getCarPrice()));
							dao.insert(car);
							cars = dao.getID();
						response.setCarID(cars.get(0).getCarID());
							response.setStatus("success");
						} else {
							throw new ServiceValidation("input not null ");
						}
					} else {
						throw new ServiceValidation("input not null");
					}
				} else {
					throw new ServiceValidation("input not null");
				}
			} else {
				throw new ServiceValidation("input not null");
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public DeleteCarResponse delete(DeleteCarRequest request) throws Exception {
		DeleteCarResponse response = new DeleteCarResponse();

		Car car = new Car();
		List<Car> cars = new ArrayList<Car>();
		try {
			if (StringUtils.isNotEmptyOrNull(request.getCarID())) {
				if (IntegerUtil.isInteger(request.getCarID())) {
					car.setCarID(Integer.valueOf(request.getCarID()));
				} else {
					throw new ServiceValidation("isNotInteger");
				}
				if (car.getCarID() != 0) {
					cars = dao.find(car);
					if (!cars.isEmpty()) {
						dao.delete(car.getCarID());
						response.setStatus("success");
					} else {
						throw new ServiceValidation("CarID don't have " + request.getCarID());
					}
				} else {
					throw new ServiceValidation("isNotEmptyOrNull");
				}
			} else {
				throw new ServiceValidation("isNotEmptyOrNull");
			}
		} catch (ServiceValidation e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return response;
	}
}
