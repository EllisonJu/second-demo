package com.miki.seconddemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miki.seconddemo.domain.Girl;
import com.miki.seconddemo.enums.ResultEnum;
import com.miki.seconddemo.exception.GirlException;
import com.miki.seconddemo.propertory.GirlPropertory;

@Service
public class GirlService {

	Logger logger = LoggerFactory.getLogger(GirlService.class);
	
	@Autowired
	private GirlPropertory girlPropertory;
	
//	@Autowired
//	private ResultEnum resultEnum;
	
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
	
	/**
	 * 通过ID判断女生age
	 * @param id
	 * @return 
	 * @throws Exception 
	 */
	public void getAge(Integer id) throws Exception{
		Girl girl = girlPropertory.findById(id).get();
		Integer age = girl.getAge();
		if(age < 10){
			logger.info("你应该还在上小学吧！");
			//code 600
//			throw new GirlException(100,"你应该还在上小学吧！");
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age < 23){
			logger.info("你到了该结婚的年龄了吧！");
//			throw new GirlException(101,"你到了该结婚的年龄了吧！");
			//code 601
			throw new GirlException(ResultEnum.MARRY);
		}else{
			//code 602
			logger.info("你孩子都该有了吧！");
//			throw new GirlException(102,"你孩子都该有了吧！");
			throw new GirlException(ResultEnum.CHILDREN);
		}
	}
	
	/**
	 * 通过ID查询一个女生
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id){
		return girlPropertory.findById(id).get();
	}
}
