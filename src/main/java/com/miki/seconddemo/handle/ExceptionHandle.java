package com.miki.seconddemo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miki.seconddemo.Utils.ResultUtils;
import com.miki.seconddemo.domain.Result;
import com.miki.seconddemo.exception.GirlException;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@Autowired
	private ResultUtils resultUtils;
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		if(e instanceof GirlException) {
			GirlException girlException = (GirlException) e;
			return resultUtils.error(girlException.getCode(), girlException.getMessage());
		}else{
			logger.error("系统异常 {}", e);
			return resultUtils.error(-1, "未知错误");
		}
		
	}
}
