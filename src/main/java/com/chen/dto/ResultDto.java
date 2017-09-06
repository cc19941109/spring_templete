package com.chen.dto;

import java.io.Serializable;

public class ResultDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String message;
	private T data;

	public ResultDto() {

	}

	public ResultDto(String code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
}