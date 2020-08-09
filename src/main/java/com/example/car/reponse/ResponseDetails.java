package com.example.car.reponse;

public class ResponseDetails {
	
	private String status;

    public ResponseDetails(String message) {
        this.status = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String message) {
        this.status = message;
    }

}

