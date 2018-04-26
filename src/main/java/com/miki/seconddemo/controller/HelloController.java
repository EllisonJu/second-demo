package com.miki.seconddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miki.seconddemo.properties.GirlProperties;

@RestController
@RequestMapping("/Test")
public class HelloController {

//	@Value("${server.cupSize}")
//	private String cupSize;
//	
//	@Value("${server.age}")
//	private Integer age;
//	
//	@Value("${server.content}")
//	private String content;
	
	@Autowired
	private GirlProperties girlProperties;
	
//	@RequestMapping(value = "/say", method = RequestMethod.POST)
	@GetMapping("/say")
	public String say(@RequestParam(value="id",required = false,defaultValue = "0") Integer MyId){
		return "id:" + MyId;
	}
}
