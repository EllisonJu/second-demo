package com.miki.seconddemo.Utils;

import org.springframework.stereotype.Component;

import com.miki.seconddemo.domain.Result;

@Component
public class ResultUtils {

	public static Result success(String msg,Object object){
		Result result =new Result<>();
		result.setCode(200);
		result.setMsg(msg+"成功");
		result.setData(object);
		return result;
	}
	
	public static Result success(){
		return success(null, null);
	}
	
	public static Result error(Integer code,String msg){
		Result result =new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
