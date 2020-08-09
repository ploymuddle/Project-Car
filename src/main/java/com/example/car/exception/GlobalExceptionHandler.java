package com.example.car.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.car.constant.CommonConstant;
import com.example.car.model.FailureResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ServiceValidation.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public FailureResponse handleServiceValidation(ServiceValidation ex) {
		FailureResponse response = new FailureResponse();
		response.setStatus(CommonConstant.RESPONSE_FAIL);
		response.setMessage(ex.getMessage());
		return response;
	}

	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public FailureResponse handleServiceException(ServiceException ex) {

		FailureResponse response = new FailureResponse();
		response.setStatus(CommonConstant.RESPONSE_FAIL);
		response.setMessage(ex.getLocalizedMessage());
		return response;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public FailureResponse handleException(Exception ex) {
		FailureResponse response = new FailureResponse();
		response.setStatus(CommonConstant.RESPONSE_FAIL);
		response.setMessage(ex.getLocalizedMessage());
		return response;
	}
}