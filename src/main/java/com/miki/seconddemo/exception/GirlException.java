package com.miki.seconddemo.exception;

import com.miki.seconddemo.enums.ResultEnum;

public class GirlException extends RuntimeException {

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

//	public GirlException(Integer code,String message) {
//		super(message);
//		this.code = code;
//	}
	
	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	
}
