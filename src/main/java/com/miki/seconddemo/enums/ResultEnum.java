package com.miki.seconddemo.enums;


public enum ResultEnum {
	UNKNOW_ERROR(10,"未知错误"),
	SUCCESS(200,"成功"),
	ERROR(204,"失败"),
	PRIMARY_SCHOOL(600,"你应该还在上小学吧"),
	MARRY(601,"你到了该结婚的年龄了吧！"),
	CHILDREN(602,"你孩子都该有了吧！");
	
	private Integer code;
	
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
