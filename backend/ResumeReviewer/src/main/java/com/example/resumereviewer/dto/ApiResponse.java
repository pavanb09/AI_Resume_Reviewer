package com.example.resumereviewer.dto;

public class ApiResponse<T> {
	
	private String message;
	private T data;
	private boolean status = true;
	
	public ApiResponse(String message, T data, boolean status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public ApiResponse(String message, T data) {
		super();
		this.message = message;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	

}
