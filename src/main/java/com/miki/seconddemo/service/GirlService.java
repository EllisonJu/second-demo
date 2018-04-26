package com.miki.seconddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miki.seconddemo.domain.Girl;
import com.miki.seconddemo.propertory.GirlPropertory;

@Service
public class GirlService {

	@Autowired
	private GirlPropertory girlPropertory;
	
	@Transactional
	public void insertTwo() {
		Girl girlA = new Girl();
		girlA.setAge(22);
		girlA.setCupSize("E");
		girlPropertory.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setAge(21);
		girlB.setCupSize("DDD");
		girlPropertory.save(girlB);
	}
}
